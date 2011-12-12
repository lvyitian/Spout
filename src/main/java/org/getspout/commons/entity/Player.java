/*
 * This file is part of SpoutcraftAPI (http://wiki.getspout.org/).
 * 
 * SpoutcraftAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SpoutcraftAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.getspout.commons.entity;

public interface Player extends HumanEntity{

	/**
	 * Is true if this player is online
	 * @return online
	 */
	public boolean isOnline();

	/**
	 * Returns if the player is in sneak mode
	 * @return true if player is in sneak mode
	 */
	public boolean isSneaking();

	/**
	 * Sets the sneak mode the player
	 * @param sneak true if player should appear sneaking
	 */
	public void setSneaking(boolean sneak);
}
