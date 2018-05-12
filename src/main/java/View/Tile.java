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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static Controller.GameController.lineLength;

public class Tile extends StackPane {
    public static final int TILE_SIZE = 30;
    private Piece piece;
    public  Ellipse ell;
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int position;
    public boolean hasPiece() {
        if(piece==null)
            return false;
        return true;
    }

    public Piece getPiece() {
        return piece;
    }
    public void setDefaultFill()
    {
        ell.setFill(Color.BLUE);
    }

    public void setActiveFill()
    {
        ell.setFill(Color.GREEN);
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
        this.getChildren().add(new PieceDrawer(piece));
    }
    public void removePiece()
    {
        this.piece=null;
        this.getChildren().remove(1,this.getChildren().size());
    }

    public Tile(int x, int y,int position) {
        this.piece=null;
        this.position=position;
        ell=new Ellipse();
        ell.setRadiusX(TILE_SIZE);
        ell.setRadiusY(TILE_SIZE);
        relocate(200+(x + 1) * lineLength + x * TILE_SIZE, (y + 1) * lineLength + y * TILE_SIZE);
        setDefaultFill();
        this.getChildren().add(ell);

    }

}
