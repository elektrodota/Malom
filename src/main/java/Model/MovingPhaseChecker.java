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
 * MovingPhaseChecker class helps to decide whether the game is in put down phase.
 */
public class MovingPhaseChecker {
    PutDownPhaseChecker putDownPhaseChecker;

    /**
     * Constructs MovingPhaseChecker object.
     */
    public MovingPhaseChecker()
    {
        putDownPhaseChecker=new PutDownPhaseChecker();
    }

    /**
     * Returns true if the player is in put down phase.
     * @param player the player.
     * @return True if and only if the player is in put down phase.
     */
    public boolean isMovingPhase(Player player)
    {
        System.out.println(player.getInBoard().size());
        return !putDownPhaseChecker.isPutDownPhase(player) && player.getInBoard().size()>3;
    }
}
