package Model;

/*-
 * #%L
 * Malom
 * %%
 * Copyright (C) 2018 University of Debrecen
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

import View.Tile;

import java.util.List;

/**
 * Helps to decide whether the Player has Mill.
 */
public class MillChecker {

    public List<List<Integer>> mills;

    /**
     * Constructs MillChecker object.
     */
    public MillChecker() {
        ArrayToList atl = new ArrayToList();
        mills = atl.twoDArrayToList(new Integer[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {9, 10, 11},
                {12, 13, 14},
                {15, 16, 17},
                {18, 19, 20},
                {21, 22, 23},
                {0, 9, 21},
                {3, 10, 18},
                {6, 11, 15},
                {1, 4, 7},
                {16, 19, 22},
                {8, 12, 17},
                {5, 13, 20},
                {2, 14, 23},
        });
    }


    /**
     * Return true if the Player has mill.
     * @param tile
     * @param board
     * @return
     */
    public boolean isMill(Tile tile, Tile board[]) {
        int position = tile.getPosition();
        for (List<Integer> list : mills) {
            if (list.contains(position)) {
                boolean result = true;
                for (int i : list) {
                    if (board[i].hasPiece()) {
                        if (i != position && board[i].getPiece().getPieceType() != board[position].getPiece().getPieceType())
                            result = false;
                    } else
                        result = false;


                }
                if (result)
                    return true;

            }


        }
        return false;
    }
}
