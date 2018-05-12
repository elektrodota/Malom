package Model;

/*-
 * #%L
 * Malom
 * %%
 * Copyright (C) 2018 GNU GENERAL PUBLIC LICENSE
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

/**
 * PutDownPhaseChecker class is decides whether the game is in put down phase.
 */
public class PutDownPhaseChecker {

    /**
     * Constructs PutDownPhaseChecker object.
     */
    public PutDownPhaseChecker()
    {}

    /**
     * Decides whether the player is in put down phase of the game.
     * @param player the player.
     * @return True if and only if the player is in put down phase of the game.
     */
    public boolean isPutDownPhase(Player player)
    {
        return player.getInHand().size()>0;

    }
}
