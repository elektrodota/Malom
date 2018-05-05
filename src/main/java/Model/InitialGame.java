package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitialGame {
    private InitialGame(){}
    public GameStatus makeUnitialPosition()
    {
        List<Piece> pieces1=new ArrayList<Piece>();
        List<Piece> pieces2=new ArrayList<Piece>();
        Random random=new Random();
        boolean isWhite=random.nextBoolean();

        for(int i=0;i<9;i++)
        {
           pieces1.add(new Piece(-1,-1,isWhite?PieceType.WHITE:PieceType.BLACK));
           pieces2.add(new Piece(-1,-1,isWhite?PieceType.BLACK:PieceType.WHITE));
        }
        Player player1 = new Player(pieces1,isWhite);
        Player player2 = new Player(pieces2,!isWhite);
        return new GameStatus(player1,player2);

    }
}
