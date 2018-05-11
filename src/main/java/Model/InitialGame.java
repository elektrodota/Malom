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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class InitialGame {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitialGame.class.getName());

    private static final Integer[][] NEIGHBOURS = {
            {1, 9},
            {0, 2, 4},
            {1, 14},
            {4, 10},
            {1, 3, 5, 7},
            {4, 13},
            {7, 11},
            {4, 6, 8},
            {7, 12},
            {0, 10, 21},
            {3, 9, 11, 18},
            {6, 10, 15},
            {8, 13, 17},
            {5, 12, 14, 20},
            {2, 13, 23},
            {11, 16},
            {15, 17, 19},
            {12, 16},
            {10, 19},
            {16, 18, 20, 22},
            {13, 19},
            {9, 22},
            {19, 21, 23},
            {14, 22},
    };



    public InitialGame() {
    }

    public GameStatus makeInitialPosition() throws IOException {
        List<Piece> pieces1 = new ArrayList<Piece>();
        List<Piece> pieces2 = new ArrayList<Piece>();
       // Random random = new Random();
        //boolean isWhite = random.nextBoolean();
        for (int i = 0; i < 9; i++) {
            pieces1.add(new Piece(-1, PieceType.WHITE ));//isWhite ? PieceType.WHITE : PieceType.BLACK));
            pieces2.add(new Piece(-1, PieceType.BLACK ));//isWhite ? PieceType.BLACK : PieceType.WHITE));
        }
        Player player1 = new Player(pieces1, true);
        Player player2 = new Player(pieces2, false);



        return new GameStatus(player1, player2, NEIGHBOURS);
    }

}
