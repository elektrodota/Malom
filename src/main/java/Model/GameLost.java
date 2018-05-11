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
 * GameLost class helps to decide whether the game is lost.
 */
public class GameLost {

    PutDownPhaseChecker putDownPhaseChecker;

    /**
     * Constructs GameLost object.
     */
    public GameLost()
    {
        putDownPhaseChecker =new PutDownPhaseChecker();

    }

    /**
     * Helps to decide whether the Player is lost because of few pieces left.
     * @param player
     * @return
     */
    public boolean isLost(Player player)
    {
        return  !putDownPhaseChecker.isPutDownPhase(player) &&player.getInBoard().size()<3;
    }
}
