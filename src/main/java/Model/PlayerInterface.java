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
 * Represents an abstraction of a player for a game.
 * PlayerInterface has methods to move the player pieces, set and get player color.
 */
public interface PlayerInterface {

        /**
         * Move the @code{piece} to the @{boardPosition}.
         * @param piece The piece which has to move
         * @param boardPosition The position in the board where the piece moves.
         */
        void movePiece(Piece piece, int boardPosition);

        /**
         * Set the player color.
         * @param whoIsWhite
         */
        void setWhite(boolean whoIsWhite);

        /**
         * Get the color of the players pieces.
         * @return
         */
        PieceType getPieceType();
}
