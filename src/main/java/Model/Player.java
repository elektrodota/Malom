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

import java.util.List;

public class Player implements PlayerInterface {
    private List<PieceInterface> pieces;
    private boolean isWhite;
    public Player(List<Piece> pieceLiest, boolean isWhite)
    {
        this.pieces.addAll(pieceLiest);
        this.isWhite=isWhite;
    }
    @Override
    public void movePiece(Piece piece,int boardX,int boardY) {
        piece.moveToPosition(boardX,boardY);
    }

    @Override
    public void setWhite(boolean isWhite)
    {
        this.isWhite=isWhite;
    }
    @Override
    public boolean getWhite()
    {
        return this.isWhite;
    }



}
