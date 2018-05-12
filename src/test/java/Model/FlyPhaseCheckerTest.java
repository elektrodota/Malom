package Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class FlyPhaseCheckerTest {
    FlyPhaseChecker flyPhaseChecker;
    @Before
    public void setUpGame()
    {
        flyPhaseChecker=new FlyPhaseChecker();

    }
    @Test
    public void testIfIsInPutDownPhase()
    {
        List<Piece>pieces=new ArrayList<>();
        pieces.add(new Piece(0,PieceType.WHITE));
        pieces.add(new Piece(1,PieceType.WHITE));
        pieces.add(new Piece(2,PieceType.WHITE));
        Player player=new Player(pieces,true);
        Assert.assertFalse(flyPhaseChecker.isFlyingPhase(player));
    }
    @Test
    public void testIfIsInMovingPhase()
    {
        List<Piece>pieces=new ArrayList<>();
        pieces.add(new Piece(0,PieceType.WHITE));
        pieces.add(new Piece(1,PieceType.WHITE));
        pieces.add(new Piece(2,PieceType.WHITE));
        pieces.add(new Piece(3,PieceType.WHITE));
        Player player=new Player(pieces,true);
        while (player.getInHand().size()>0)
        {
            player.getInBoard().add(player.getInHand().remove(0));
        }
        Assert.assertFalse(flyPhaseChecker.isFlyingPhase(player));


    }
    @Test
    public void testIfIsInFlyingPhase()
    {
        List<Piece>pieces=new ArrayList<>();
        pieces.add(new Piece(0,PieceType.WHITE));
        pieces.add(new Piece(1,PieceType.WHITE));
        pieces.add(new Piece(2,PieceType.WHITE));
        Player player=new Player(pieces,true);

        while (player.getInHand().size()>0)
        {
            player.getInBoard().add(player.getInHand().remove(0));
        }
        Assert.assertTrue(flyPhaseChecker.isFlyingPhase(player));
    }



}