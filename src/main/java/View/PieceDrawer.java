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

import Model.Piece;
import Model.PieceType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class PieceDrawer extends StackPane implements Drawer {
    private static int TILE_SIZE=50;
    Piece piece;
    public PieceDrawer(Piece piece)
    {
        this.piece=piece;
    }
    @Override
    public void draw()
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
