package Model;

public interface PlayerInterface {

        void movePiece(Piece piece, int boardX, int boardY);
        void setWhite(boolean whoIsWhite);
        boolean getWhite();
}
