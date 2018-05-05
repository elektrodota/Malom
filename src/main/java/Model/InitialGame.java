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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitialGame {
    private InitialGame(){}
    public GameStatus makeUnitialPosition()
    {
        List<Piece> pieces1=new ArrayList<Piece>();
        List<Piece> pieces2=new ArrayList<Piece>();
        Random random=new Random();
        boolean isWhite=random.nextBoolean();

        for(int i=0;i<9;i++)
        {
           pieces1.add(new Piece(-1,-1,isWhite?PieceType.WHITE:PieceType.BLACK));
           pieces2.add(new Piece(-1,-1,isWhite?PieceType.BLACK:PieceType.WHITE));
        }
        Player player1 = new Player(pieces1,isWhite);
        Player player2 = new Player(pieces2,!isWhite);
        return new GameStatus(player1,player2);
    }
}
