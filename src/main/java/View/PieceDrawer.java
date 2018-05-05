package View;

import Model.Piece;
import Model.PieceType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class PieceDrawer extends StackPane {
    private static int TILE_SIZE=50;
    private PieceDrawer()
    {
    }
    public void draw(Piece piece)
    {

        Ellipse background=new Ellipse(TILE_SIZE*0.32,TILE_SIZE*0.26);
        background.setStroke(Color.BLACK);
        background.setStrokeWidth(TILE_SIZE*0.35);
        //
        Ellipse ellipse=new Ellipse(TILE_SIZE*0.32,TILE_SIZE*0.26);
        ellipse.setFill(piece.getPieceType()== PieceType.WHITE ? Color.GHOSTWHITE :Color.CHOCOLATE);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(TILE_SIZE*0.35);
        getChildren().addAll(background,ellipse);
    }
}
