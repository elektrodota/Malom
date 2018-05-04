package View;

import Model.Piece;
import Model.PieceType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class PieceDrawer extends StackPane {
    private Piece piece;
    private static int TILE_SIZE=50;
    public PieceDrawer(Piece piece)
    {
        this.piece=piece;
    }
    public void draw()
    {
        Ellipse ellipse=new Ellipse(TILE_SIZE*0.32,TILE_SIZE*0.26);
        ellipse.setFill(piece.getPieceType()== PieceType.WHITE ? Color.GHOSTWHITE :Color.CHOCOLATE);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(TILE_SIZE*0.35);
        getChildren().addAll(ellipse);
    }
}
