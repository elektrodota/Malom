package Model;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class GameStatus implements  GameStatusInterface {
    PlayerInterface player1,player2;
    public GameStatus(Player player1,Player player2)
    {
        boolean whoIsWhite = ThreadLocalRandom.current().nextBoolean();
        this.player1=player1;
        this.player2=player2;

        this.player1.setWhite(whoIsWhite);
        this.player2.setWhite(!whoIsWhite);
    }


}
