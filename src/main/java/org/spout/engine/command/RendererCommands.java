/*
 * This file is part of Spout.
 *
 * Copyright (c) 2011-2012, SpoutDev <http://www.spout.org/>
 * Spout is licensed under the SpoutDev License Version 1.
 *
 * Spout is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Spout is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.engine.command;

import com.bulletphysics.collision.shapes.BoxShape;
import org.spout.api.Spout;
import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.component.components.PhysicsComponent;
import org.spout.api.geo.World;
import org.spout.engine.SpoutClient;
import org.spout.engine.SpoutEngine;
import org.spout.engine.entity.SpoutPlayer;
import org.spout.engine.world.SpoutRegion;

public class RendererCommands {
	private final SpoutClient client;
	public RendererCommands(SpoutClient client) {
		this.client = client;
	}

	@Command(aliases = {"r_wireframe"}, desc = "Toggles Wireframe for the renderer")
	public void toggleWireframe(CommandContext args, CommandSource source) {
		client.enqueueTask(new Runnable(){
			public void run() {
				Spout.log("Toggling Wireframe");
				client.toggleWireframe();
			}
		});
	}

    @Command(aliases = {"r_noclip"}, desc = "Toggles noclip on the client")
    public void toggleNoClip(CommandContext args, CommandSource source) {
        client.enqueueTask(new Runnable(){
            public void run() {
                Spout.log("Toggling Physics...");
                final SpoutPlayer player = client.getActivePlayer();
                if (player.has(PhysicsComponent.class)) {
                    Spout.log("Detaching Physics...");
                    player.detach(PhysicsComponent.class);
                } else {
                    PhysicsComponent physics = player.add(PhysicsComponent.class);
                    physics.setMass(5.0f);
                    physics.setCollisionShape(new BoxShape(1, 3, 1));
                    physics.setRestitution(0);
                    physics.setDamping(.5f, 0f);
                    Spout.log("Adding Physics...");
                    ((SpoutRegion) player.getRegion()).addPhysics(player);
                }
            }
        });
    }
}
