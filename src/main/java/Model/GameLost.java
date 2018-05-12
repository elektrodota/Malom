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

import View.Tile;

/**
 * GameLost class helps to decide whether the game is lost.
 */
public class GameLost {

    PutDownPhaseChecker putDownPhaseChecker;

    /**
     * Constructs GameLost object.
     */
    public GameLost()
    {
        putDownPhaseChecker =new PutDownPhaseChecker();

    }

    /**
     * Helps to decide whether the Player is lost because of few pieces left.
     * @param player the player.
     * @return a boolean about the game is lost.
     */
    public boolean isLostByFewPiecesLeft(Player player)
    {
        return !putDownPhaseChecker.isPutDownPhase(player) &&player.getInBoard().size()<3;
    }

    /**
     * isLostByNoValidMoveLeft method decides whether the player has valid move left.
     * @param player the player.
     * @param board the board.
     * @param gs the game state.
     * @return True if and only if the player has no valid move left.
     */
    public boolean isLostByNoValidMoveLeft(Player player, Tile[] board,GameStatus gs)
    {
        for(int i=0;i<board.length;i++)
        {
            if(board[i].hasPiece())
            {
                if(board[i].getPiece().getPieceType()==player.getPieceType() && hasLegalMove(board,gs,i))
                {
                   return false;

                }
            }
        }
        return true;
    }

    /**
     * @param board the board of the game.
     * @param gs the status of the game.
     * @param i the tile position
     * @return True if and only if the piece in position i has legal move.
     */
    public boolean hasLegalMove(Tile[] board,GameStatus gs,int i)
    {
        for(int j=0;j<gs.Neighbours.get(i).size();j++)
        {
            if(!board[gs.Neighbours.get(i).get(j)].hasPiece())
                return true;
        }
        return false;
    }

}
