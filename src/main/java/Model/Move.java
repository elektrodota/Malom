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

/**
 * Move class to make moves in the board.
 */
public class Move {

    /**
     * Constructs move object.
     */
    public Move(){}
    /**
     * The <code>Player</code> puts down a <code>Piece</code> to the <code>Tile</code>.
     *
     * @param player The player who put down a piece.
     * @param tile   The tile where the player puts the piece.
     */
    public void putDown(Player player, Tile tile ){
        if(!tile.hasPiece()) {
            Piece p = (Piece) player.getInHand().remove(0);
            p.moveToPosition(tile.getPosition());
            tile.setPiece(p);
            player.getInBoard().add(p);
        }
    }
    /**
     * Moves a <code>Piece</code> from <code>Tile</code> to <code>Tile</code>.
     *
     * @param from the Tile from the piece moves.
     * @param to the Tile where the piece moves.
     */
    public void movePiece(Tile from, Tile to) {
        if (from != null && !to.hasPiece() && from.hasPiece()) {
            Piece p = from.getPiece();
            p.moveToPosition(to.getPosition());
            to.setPiece(p);
            from.removePiece();
            from.setDefaultFill();
        }

    }

}
