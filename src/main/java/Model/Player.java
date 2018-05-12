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

/**
 * Player class represents a player.
 */

public class Player implements PlayerInterface {
    private List<PieceInterface> inBoard;
    private List<PieceInterface> inHand;
    private boolean isWhite;

    /**
     * Contructs Player object.
     * @param pieceLiest list of the pieces.
     * @param isWhite is the player with white or black color.
     */
    public Player(List<Piece> pieceLiest, boolean isWhite)
    {
        this.inHand=new ArrayList<>();
        this.inHand.addAll(pieceLiest);
        this.inBoard=new ArrayList<>();
        this.isWhite=isWhite;
    }

    /**
     * @return the pieces from the board.
     */
    public List<PieceInterface> getInBoard() {
        return inBoard;
    }

    /**
     * @return the pieces from the players hand.
     */
    public List<PieceInterface> getInHand() {
        return inHand;
    }

    @Override
    public void movePiece(Piece piece,int boardPosition) {
        piece.moveToPosition(boardPosition);
    }

    @Override
    public void setWhite(boolean isWhite)
    {
        this.isWhite=isWhite;
    }
    @Override
    public PieceType getPieceType()
    {
        return this.isWhite?PieceType.WHITE:PieceType.BLACK;
    }

    /**
     * Removes the piece from the lise.
     * @param p the piece.
     */
    public void removePiece(Piece p)
    {
        for(int i=0;i<inBoard.size();i++)
        {
            if(inBoard.get(i).getPosition()==p.getPosition())
            {
                inBoard.remove(i);
            }
        }
    }



}
