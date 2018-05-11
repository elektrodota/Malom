package Controller;

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

import Model.*;
import View.GameDrawer;
import View.Tile;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *  FXML Controller class for controll game changes.
 */
public class GameController implements Initializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class.getName());
    public static final int lineLength = 50;
    @FXML
    private AnchorPane pane;
    @FXML
    private VBox gameBox;
    @FXML
    private TextField POne, PTwo;
    GameStatus gameStatus;
    boolean isPlayer1;
    private PutDownPhaseChecker putDownPhaseChecker;
    private MovingPhaseChecker movingPhaseChecker;
    private GameDrawer gameDrawer;
    private MillChecker millChecker;
    private Tile from;
    private boolean isMill;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        InitialGame init = new InitialGame();
        try {
            gameStatus = init.makeInitialPosition();
        } catch (IOException e) {
            LOGGER.error(e.toString());
        }

        isPlayer1 = true;
        this.putDownPhaseChecker = new PutDownPhaseChecker();
        this.gameDrawer = new GameDrawer();
        this.movingPhaseChecker = new MovingPhaseChecker();
        this.millChecker = new MillChecker();
        from = null;
        isMill = false;
    }


    /**
     * Creates initial @code{gameStatus}
     */
    public void createInitialGame() {
        gameDrawer.drawInitialGame(gameStatus);
        for (Tile t : gameDrawer.getBoard()) {
            t.setOnMouseClicked(ev());
        }
        this.pane.getChildren().add(gameDrawer);
        LOGGER.info("The initial game has been created");
    }


    /**
     * Event handler for tiles.
     * @return EventHandler<MouseEvent>
     */
    private EventHandler<MouseEvent> ev() {
        EventHandler event = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Tile tile = (Tile) t.getSource();

                if (!tile.hasPiece()) {
                    if (!isMill) {
                        if (isPlayer1) {
                            if (putDownPhaseChecker.isPutDownPhase(gameStatus.getPlayer1())) {
                                putDown(gameStatus.getPlayer1(), tile);
                                isMill = millChecker.isMill(tile, gameDrawer.getBoard());
                            } else {
                                if (from != null) {
                                    if (movingPhaseChecker.isMovingPhase(gameStatus.getPlayer1()) && gameStatus.isNeighbour(from.getPosition(), tile.getPosition())) {
                                        movePiece(from,tile);
                                        isMill = millChecker.isMill(tile, gameDrawer.getBoard());
                                    }
                                }
                            }
                        } else {
                            if (putDownPhaseChecker.isPutDownPhase(gameStatus.getPlayer2())) {
                                putDown(gameStatus.getPlayer2(), tile);
                                PTwo.setText("Remaining: " + gameStatus.getPlayer2().getInHand().size());
                                isMill = millChecker.isMill(tile, gameDrawer.getBoard());
                            } else {
                                if (from != null) {
                                    if (movingPhaseChecker.isMovingPhase(gameStatus.getPlayer2()) && gameStatus.isNeighbour(from.getPosition(), tile.getPosition())) {
                                        movePiece(from,tile);
                                        isMill = millChecker.isMill(tile, gameDrawer.getBoard());
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (isPlayer1 && tile.getPiece().getPieceType() == PieceType.WHITE) {
                        setFrom(tile);
                    }
                    if (!isPlayer1 && tile.getPiece().getPieceType() == PieceType.BLACK) {
                        setFrom(tile);
                    }
                    if (isMill) {
                        if (isPlayer1 && !millChecker.isMill(tile, gameDrawer.getBoard()) && tile.getPiece().getPieceType()==gameStatus.getPlayer1().getPieceType()) {
                            Piece piece = tile.getPiece();
                            gameStatus.getPlayer1().getInBoard().remove(piece);
                            tile.removePiece();
                            isMill = false;

                        }
                        if (!isPlayer1 && !millChecker.isMill(tile, gameDrawer.getBoard())&& tile.getPiece().getPieceType()==gameStatus.getPlayer2().getPieceType()) {

                            Piece piece = tile.getPiece();
                            gameStatus.getPlayer2().getInBoard().remove(piece);
                            tile.removePiece();
                            isMill = false;
                        }
                        from=null;

                    }

                }

            }
        };
        return event;
    }

    /**
     * The @code{player}Puts down a @code{piece} to the @code{tile}
     * @param player The player who put down a piece.
     * @param tile The tile where the player puts the piece.
     */
    private void putDown(Player player, Tile tile) {
        Piece p = (Piece) player.getInHand().remove(0);
        tile.setPiece(p);
        player.getInBoard().add(p);
        tile.setPiece(p);
        isPlayer1 = !isPlayer1;
    }

    /**
     * Moves a piece from @code{tile} to @code{tile}.
     * @param from
     * @param to
     */
    private void movePiece(Tile from,Tile to) {
        if (from != null) {
            Piece p = from.getPiece();
            to.setPiece(new Piece(p.getPosition(), p.getPieceType()));
            from.removePiece();
            from.setDefaultFill();
            from = null;
            isPlayer1 = !isPlayer1;
        }

    }

    /**
     * Sets @code{from tile}.
     * @param tile
     */
    private void setFrom(Tile tile) {
        if (from != null) {
            from.setDefaultFill();
        }
        from = tile;
        tile.setActiveFill();

    }


}
