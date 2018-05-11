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
 * Piece class represents a piece for the game.
 */
public class Piece implements PieceInterface {
    private int position;
    private PieceType pieceType;

    /**
     * Constructs Piece object.
     * @param position
     * @param pieceType
     */
    public Piece(int position, PieceType pieceType)
    {
        this.position=position;
        this.pieceType=pieceType;
    }

    /**
     * Returns the color of the piece.
     * @return
     */
    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public void moveToPosition(int position) {
        this.position=position;
    }

    @Override
    public int getPosition() {
        return position;
    }


}
