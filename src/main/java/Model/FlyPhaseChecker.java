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
 *  FlyPhaseChecker class helps to decide whether the game is in flying phase.
 */
public class FlyPhaseChecker {
    PutDownPhaseChecker putDownPhaseChecker;
    MovingPhaseChecker movingPhaseChecker;

    /**
     * Constructs FlyPhaseChecker object.
     */
    public FlyPhaseChecker()
    {
        this.putDownPhaseChecker=new PutDownPhaseChecker();
        this.movingPhaseChecker =new MovingPhaseChecker();
    }

    /**
     * Checks whether the Player can fly.
     * @param player the player.
     * @return boolean about the player can fly.
     */
    public boolean isFlyingPhase(Player player)
    {
        return player.getInBoard().size()==3;
    }

}
