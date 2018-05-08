package View;

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

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class GameDrawer extends Pane implements Drawer {

    Tile[][] board=new Tile[3][3];
    public GameDrawer(Tile[][] board) {
            addNewBoard(board);

    }
    public void addNewBoard(Tile[][] board)
    {
        for(int i=0;i<3;i++)
         for(int j=0;j<3;j++)
         {
             this.board[i][j]=board[i][j];
         }
    }


    @Override
    public void draw() {

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                this.getChildren().add(board[i][j]);
                if(board[i][j].hasPiece())
                    this.getChildren().add(new PieceDrawer(board[i][j].getPiece()));
            }
        }
    }
}
