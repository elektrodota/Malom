package View;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class GameDrawer extends Pane {
    Group tileGroup,pieceGroup;

    public GameDrawer(Tile board[][]) {
        this.tileGroup = new Group();
        this.pieceGroup=new Group();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                this.tileGroup.getChildren().add(board[i][j]);
            }
        }
    }



}
