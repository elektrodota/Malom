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

import Model.GameStatus;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import static View.Tile.TILE_SIZE;

public class GameDrawer extends Pane{

    Tile[] board = new Tile[24];

    public Tile[] getBoard() {
        return board;
    }

    public GameDrawer() {
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    board[i * 3 + 0] = new Tile(0, 0,i * 3 + 0);

                    board[i * 3 + 1] = new Tile(0, 3,i * 3 + 1);
                    board[i * 3 + 2] = new Tile(0, 6,i * 3 + 2);

                    break;
                case 1:
                    board[i * 3 + 0] = new Tile(1, 1,i * 3 + 0);
                    board[i * 3 + 1] = new Tile(1, 3,i * 3 + 1);
                    board[i * 3 + 2] = new Tile(1, 5,i * 3 + 2);
                    break;

                case 2:
                    board[i * 3 + 0] = new Tile(2, 2,i * 3 + 0);
                    board[i * 3 + 1] = new Tile(2, 3,i * 3 + 1);
                    board[i * 3 + 2] = new Tile(2, 4,i * 3 + 2);
                    break;
                case 3:
                    board[i * 3 + 0] = new Tile(3, 0,i * 3 + 0);
                    board[i * 3 + 1] = new Tile(3, 1,i * 3 + 1);
                    board[i * 3 + 2] = new Tile(3, 2,i * 3 + 2);
                    break;
                case 4:
                    board[i * 3 + 0] = new Tile(3, 4,i * 3 + 0);
                    board[i * 3 + 1] = new Tile(3, 5,i * 3 + 1);
                    board[i * 3 + 2] = new Tile(3, 6,i * 3 + 2);
                    break;
                case 5:
                    board[i * 3 + 0] = new Tile(4, 2,i * 3 + 0);
                    board[i * 3 + 1] = new Tile(4, 3,i * 3 + 1);
                    board[i * 3 + 2] = new Tile(4, 4,i * 3 + 2);
                    break;

                case 6:
                    board[i * 3 + 0] = new Tile(5, 1,i * 3 + 0);
                    board[i * 3 + 1] = new Tile(5, 3,i * 3 + 1);
                    board[i * 3 + 2] = new Tile(5, 5,i * 3 + 2);
                    break;
                case 7:
                    board[i * 3 + 0] = new Tile(6, 0,i * 3 + 0);
                    board[i * 3 + 1] = new Tile(6, 3,i * 3 + 1);
                    board[i * 3 + 2] = new Tile(6, 6,i * 3 + 2);
                    break;
            }

        }

    }



    public void drawInitialGame(GameStatus gameStatus) {



        for (int i = 0; i < gameStatus.Neighbours.size(); i++) {
            double startX = board[i].getLayoutX() + TILE_SIZE;
            double startY = board[i].getLayoutY() + TILE_SIZE;
            for (int j = 0; j < gameStatus.Neighbours.get(i).size(); j++) {
                Line l = new Line(startX, startY, board[gameStatus.Neighbours.get(i).get(j)].getLayoutX() + TILE_SIZE, board[gameStatus.Neighbours.get(i).get(j)].getLayoutY() + TILE_SIZE);
                l.setFill(Color.BLACK);
                l.setStrokeWidth(5);
                this.getChildren().add(l);
            }
        }

        this.getChildren().addAll(board);




    }



}
