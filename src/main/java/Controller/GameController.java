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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML controller class for controll game changes.
 */
public class GameController implements Initializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class.getName());
    /**
     * <code>linelength</code> is the length of the drawing lines.
     */
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
    private FlyPhaseChecker flyPhaseChecker;
    private GameLost gameLost;

    private Move move;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        InitialGame init = new InitialGame();
        gameStatus = init.makeInitialPosition();


        isPlayer1 = true;
        this.putDownPhaseChecker = new PutDownPhaseChecker();
        this.gameDrawer = new GameDrawer();
        this.movingPhaseChecker = new MovingPhaseChecker();
        this.millChecker = new MillChecker();
        this.flyPhaseChecker = new FlyPhaseChecker();
        move = new Move();
        from = null;
        isMill = false;
        this.gameLost = new GameLost();
    }


    /**
     * Creates initial <code>GameStatus</code> .
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
     *
     * @return <code>EventHandler<MouseEvent></code>
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
                                move.putDown(gameStatus.getPlayer1(), tile);
                                POne.setText("Remaining: " + gameStatus.getPlayer1().getInHand().size());
                                isPlayer1 = !isPlayer1;
                                isMill = millChecker.isMill(tile, gameDrawer.getBoard());
                            } else {
                                if (from != null) {
                                    if (movingPhaseChecker.isMovingPhase(gameStatus.getPlayer1()) && gameStatus.isNeighbour(from.getPosition(), tile.getPosition())) {
                                        move.movePiece(from, tile);
                                        isMill = millChecker.isMill(tile, gameDrawer.getBoard());
                                        isPlayer1 = !isPlayer1;
                                        if (gameLost.isLostByNoValidMoveLeft(gameStatus.getPlayer2(), gameDrawer.getBoard(), gameStatus)) {
                                            Stage stage = (Stage) ((Node) (t.getSource())).getScene().getWindow();
                                            try {
                                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Win.fxml"));
                                                Parent root = (Parent) fxmlLoader.load();
                                                Scene sc = new Scene(root);
                                                WinnerController controller = fxmlLoader.<WinnerController>getController();
                                                controller.setPlayerWinMessage("Player 1 won");
                                                stage.setScene(sc);
                                                stage.show();

                                            } catch (IOException err) {
                                                LOGGER.error(err.toString());
                                            }
                                            LOGGER.info("Player 1 won");
                                        }

                                    }
                                    if (flyPhaseChecker.isFlyingPhase(gameStatus.getPlayer1())) {
                                        move.movePiece(from, tile);
                                        isPlayer1 = !isPlayer1;
                                        isMill = millChecker.isMill(tile, gameDrawer.getBoard());
                                    }


                                }
                            }
                        } else {
                            if (putDownPhaseChecker.isPutDownPhase(gameStatus.getPlayer2())) {
                                move.putDown(gameStatus.getPlayer2(), tile);
                                PTwo.setText("Remaining: " + gameStatus.getPlayer2().getInHand().size());
                                isPlayer1 = !isPlayer1;
                                isMill = millChecker.isMill(tile, gameDrawer.getBoard());
                            } else {
                                if (from != null) {
                                    if (movingPhaseChecker.isMovingPhase(gameStatus.getPlayer2()) && gameStatus.isNeighbour(from.getPosition(), tile.getPosition())) {
                                        move.movePiece(from, tile);
                                        isPlayer1 = !isPlayer1;
                                        isMill = millChecker.isMill(tile, gameDrawer.getBoard());
                                        if (gameLost.isLostByNoValidMoveLeft(gameStatus.getPlayer1(), gameDrawer.getBoard(), gameStatus)) {
                                            Stage stage = (Stage) ((Node) (t.getSource())).getScene().getWindow();
                                            try {
                                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Win.fxml"));
                                                Parent root = (Parent) fxmlLoader.load();
                                                Scene sc = new Scene(root);
                                                WinnerController controller = fxmlLoader.<WinnerController>getController();
                                                controller.setPlayerWinMessage("Player 2 won");
                                                stage.setScene(sc);
                                                stage.show();

                                            } catch (IOException err) {
                                                LOGGER.error(err.toString());
                                            }
                                            LOGGER.info("Player 2 won");
                                        }


                                    }
                                    if (flyPhaseChecker.isFlyingPhase(gameStatus.getPlayer2())) {
                                        move.movePiece(from, tile);
                                        isPlayer1 = !isPlayer1;
                                        isMill = millChecker.isMill(tile, gameDrawer.getBoard());


                                    }
                                }
                            }
                        }
                    }
                } else {

                    if (isMill) {
                        if (isPlayer1 && tile.getPiece().getPieceType() == gameStatus.getPlayer1().getPieceType() && (!millChecker.isMill(tile, gameDrawer.getBoard()) || millChecker.isAllPiecesInMil(gameStatus.getPlayer1(), gameDrawer.getBoard()))) {
                            Piece piece = tile.getPiece();
                            gameStatus.getPlayer1().removePiece(piece);
                            tile.removePiece();
                            if (gameLost.isLostByFewPiecesLeft(gameStatus.getPlayer1()) || gameLost.isLostByNoValidMoveLeft(gameStatus.getPlayer1(), gameDrawer.getBoard(), gameStatus)) {
                                Stage stage = (Stage) ((Node) (t.getSource())).getScene().getWindow();
                                try {
                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Win.fxml"));
                                    Parent root = (Parent) fxmlLoader.load();
                                    Scene sc = new Scene(root);
                                    WinnerController controller = fxmlLoader.<WinnerController>getController();
                                    controller.setPlayerWinMessage("Player 2 won");
                                    stage.setScene(sc);
                                    stage.show();

                                } catch (IOException err) {
                                    LOGGER.error(err.toString());
                                }
                                LOGGER.info("Player 2 won");
                            }
                            isMill = false;


                        }
                        if (!isPlayer1 && tile.getPiece().getPieceType() == gameStatus.getPlayer2().getPieceType() && (!millChecker.isMill(tile, gameDrawer.getBoard()) || millChecker.isAllPiecesInMil(gameStatus.getPlayer2(), gameDrawer.getBoard()))) {

                            Piece piece = tile.getPiece();
                            gameStatus.getPlayer2().removePiece(piece);
                            tile.removePiece();
                            if (gameLost.isLostByFewPiecesLeft(gameStatus.getPlayer2()) || gameLost.isLostByNoValidMoveLeft(gameStatus.getPlayer2(), gameDrawer.getBoard(), gameStatus)) {
                                Stage stage = (Stage) ((Node) (t.getSource())).getScene().getWindow();
                                try {
                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Win.fxml"));
                                    Parent root = (Parent) fxmlLoader.load();
                                    Scene sc = new Scene(root);
                                    WinnerController controller = fxmlLoader.<WinnerController>getController();
                                    controller.setPlayerWinMessage("Player 1 won");
                                    stage.setScene(sc);
                                    stage.show();

                                } catch (IOException err) {
                                    LOGGER.error(err.toString());
                                }
                                LOGGER.info("Player 1 won");
                            }
                            isMill = false;
                        }
                        from = null;

                    } else {
                        if (isPlayer1 && tile.getPiece().getPieceType() == PieceType.WHITE) {
                            setFrom(tile);
                        }
                        if (!isPlayer1 && tile.getPiece().getPieceType() == PieceType.BLACK) {
                            setFrom(tile);
                        }
                    }

                }


            }
        };
        return event;
    }


    /**
     * Sett<code> Tile from</code>.
     *
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
