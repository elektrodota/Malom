package Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameStatusTest {
    GameStatus gameStatus;
    InitialGame initialGame;
    @Before
    public void setUp()
    {
        initialGame=new InitialGame();
        gameStatus=initialGame.makeInitialPosition();
    }
    @Test
    public void isNeighbour() {
        Assert.assertTrue(gameStatus.isNeighbour(0,1));
        Assert.assertFalse(gameStatus.isNeighbour(0,19));
    }
}