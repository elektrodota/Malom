package View;


import Model.Piece;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Tile extends Ellipse {
    public static final int TILE_SIZE=50;
    private Piece piece;
    public boolean hasPiece()
    {
        return piece!=null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public Tile(int x,int y)
    {
        setRadiusX(TILE_SIZE);
        setRadiusY(TILE_SIZE);
        relocate((x+1)*100+x*TILE_SIZE,(y+1)*100+y*TILE_SIZE);
        setFill(Color.AZURE);
    }
}
