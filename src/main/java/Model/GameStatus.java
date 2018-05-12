package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * GameStatus class represents the status of the game.
 */
public class GameStatus {
    Player player1,player2;
    /**
     * The list of the neighbour tiles.
     */
    public List<List<Integer>> Neighbours;



    /**
     * Construct GameStatus object.
     * @param player1 Player1 for the game.
     * @param player2 Player 2 for the game.
     * @param neighbours The neighbour tiles positions.
     */
    public GameStatus(Player player1, Player player2, Integer[][] neighbours)
    {
        ArrayToList atl=new ArrayToList();
        this.player1=player1;
        this.player2=player2;
        this.Neighbours=atl.twoDArrayToList(neighbours);
    }

    /**
     * @return Player1 player.
     */
    public Player getPlayer1() {
        return player1;
    }


    /**
     * @return player 2 Player
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Helps to decide whether @code{from} and @code{to} is neighbours.
     * @param from the position from the move happens.
     * @param to the position to the move happens.
     * @return true if the two tile are neighbours.
     */
    public boolean isNeighbour(int from,int to)
    {
        for(int i=0;i<Neighbours.get(from).size();i++)
        {
            if(Neighbours.get(from).get(i)==to)
                return true;
        }
        return false;
    }
}
