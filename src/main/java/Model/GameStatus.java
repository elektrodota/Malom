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
public class GameStatus {
    Player player1,player2;
    public List<List<Integer>> Neighbours;

    public GameStatus(Player player1, Player player2, Integer[][] neighbours)
    {
        ArrayToList atl=new ArrayToList();
        this.player1=player1;
        this.player2=player2;
        this.Neighbours=atl.twoDArrayToList(neighbours);
    }


    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
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
