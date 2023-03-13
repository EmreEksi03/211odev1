import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CannonTest {

    @Test
    void move() {
    }

    @Test
    void canMove() {
        Board board = new Board();
        PawnBlack pawnBlack = new PawnBlack("g4",board);
        PawnBlack pawnBlack2 = new PawnBlack("h2",board);
        Cannon cannonBlack = new Cannon("g3",board, Type.Black);
        Cannon cannonBlack2 = new Cannon("i2",board, Type.Black);
        //@todo bu comment nedir...
        //board.items = new Item[]{pawnBlack,pawnBlack2,cannonBlack,cannonBlack2};
        //Assertions.assertFalse(cannonBlack.canMove("g7"));
        //Assertions.assertFalse(cannonBlack2.canMove("f2"));
        PawnRed pawnRed = new PawnRed("g5",board);
        PawnRed pawnRed2 = new PawnRed("f2",board);
        board.items = new  Item[]{pawnRed,pawnRed2,pawnBlack,pawnBlack2,cannonBlack,cannonBlack2};
        Assertions.assertTrue(cannonBlack.canMove("g5"));
        Assertions.assertTrue(cannonBlack2.canMove("f2"));

        Cannon cannonRed = new Cannon("b4",board,Type.Red);
        Cannon cannonRed2 = new Cannon("d2",board,Type.Red);
        PawnRed pawnRed3 = new PawnRed("b6",board);
        PawnBlack pawnBlack3 = new PawnBlack("g2",board);
        PawnBlack pawnBlack34 = new PawnBlack("g2",board);
        board.items = new  Item[]{cannonRed,cannonRed2,pawnRed3,pawnBlack3};
        Assertions.assertFalse(cannonRed.canMove("b6"));
        Assertions.assertTrue(cannonRed2.canMove("e2"));

    }
}