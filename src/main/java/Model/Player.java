package Model;

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
        isWhite=isWhite;
    }
    @Override
    public boolean getWhite()
    {
        return this.isWhite;
    }



}
