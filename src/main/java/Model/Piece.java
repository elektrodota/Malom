package Model;

public class Piece implements PieceInterface {
    private int x,y;
    private PieceType pieceType;
    Piece(int x,int y,PieceType pieceType)
    {
        this.x=x;
        this.y=y;
        this.pieceType=pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public void moveToPosition(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
