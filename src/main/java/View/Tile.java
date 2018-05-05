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
