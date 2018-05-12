package Model;

import View.GameDrawer;
import View.Tile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MillCheckerTest {
    MillChecker millChecker;
    GameStatus gameStatus;
    InitialGame initialGame;
    GameDrawer gameDrawer;
    @Before
    public void setup()
    {
        InitialGame initialGame=new InitialGame();
        gameStatus=initialGame.makeInitialPosition();
        gameDrawer=new GameDrawer();
        gameDrawer.drawInitialGame(gameStatus);
        millChecker=new MillChecker();
    }
    @Test
    public void isMill() {
        setup();
        Tile[] board=gameDrawer.getBoard();
        board[0].setPiece(new Piece(0,PieceType.WHITE));
        board[1].setPiece(new Piece(1,PieceType.WHITE));
        board[2].setPiece(new Piece(2,PieceType.WHITE));
        board[3].setPiece(new Piece(3,PieceType.WHITE));
        Assert.assertTrue(millChecker.isMill(board[0],board));
        Assert.assertFalse(millChecker.isMill(board[3],board));
    }

    @Test
    public void isAllPiecesInMil() {
        setup();
        Tile board[]=gameDrawer.getBoard();
        List <Piece> pieces=new ArrayList<>();

        for(int i=0;i<3;i++)
        {

            Piece piece=new Piece(i,PieceType.WHITE);
            board[i].setPiece(piece);
            pieces.add(piece);

        }
        Player player=new Player(pieces,true);
        player.getInHand().removeAll(pieces);
        player.getInBoard().addAll(pieces);
        Assert.assertTrue(millChecker.isAllPiecesInMil(player,board));
        Piece piece=new Piece(3,PieceType.WHITE);
        board[3].setPiece(piece);
        player.getInBoard().add(piece);
        Assert.assertFalse(millChecker.isAllPiecesInMil(player,board));


    }
}