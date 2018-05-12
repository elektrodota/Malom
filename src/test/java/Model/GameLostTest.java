package Model;

import View.GameDrawer;
import View.Tile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameLostTest {

    GameStatus gameStatus;
    GameDrawer gameDrawer;
    GameLost gameLost;
    Move move;
    @Before
    public void setUp()
    {
        InitialGame initialGame=new InitialGame();
        gameStatus=initialGame.makeInitialPosition();
        gameDrawer=new GameDrawer();
        gameDrawer.drawInitialGame(gameStatus);
        gameLost = new GameLost();
        move=new Move();
    }
    @Test
    public void isLostByFewPiecesLeft() {
        setUp();
        Assert.assertFalse(gameLost.isLostByFewPiecesLeft(gameStatus.getPlayer1()));
        gameStatus.getPlayer1().getInBoard().add(gameStatus.getPlayer1().getInHand().remove(0));
        gameStatus.getPlayer1().getInBoard().add(gameStatus.getPlayer1().getInHand().remove(0));
        gameStatus.getPlayer1().getInHand().removeAll(gameStatus.getPlayer1().getInHand());
        Assert.assertTrue(gameLost.isLostByFewPiecesLeft(gameStatus.getPlayer1()));

    }

    @Test
    public void isLostByNoValidMoveLeft() {
        setUp();
        Tile[] board = gameDrawer.getBoard();
        move.putDown(gameStatus.getPlayer1(),board[0]);
        Assert.assertFalse(gameLost.isLostByNoValidMoveLeft(gameStatus.getPlayer1(),board,gameStatus));
        move.putDown(gameStatus.getPlayer2(),board[1]);
        move.putDown(gameStatus.getPlayer2(),board[9]);
        Assert.assertTrue(gameLost.isLostByNoValidMoveLeft(gameStatus.getPlayer1(),board,gameStatus));
    }

    @Test
    public void hasLegalMove() {
        setUp();
        Tile[] board = gameDrawer.getBoard();
        move.putDown(gameStatus.getPlayer1(),board[0]);
        Assert.assertTrue(gameLost.hasLegalMove(board,gameStatus,0));
        move.putDown(gameStatus.getPlayer2(),board[1]);
        move.putDown(gameStatus.getPlayer2(),board[9]);
        Assert.assertFalse(gameLost.hasLegalMove(board,gameStatus,0));

    }
}