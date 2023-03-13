import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ElephantTest {

    @Test
    void move() {
    }

    @Test
    void canMove() {
        Board board = new Board();

        PawnBlack pawnBlack = new PawnBlack("g5",board);
        Elephant elephantBlack3 = new Elephant("i3",board, Type.Black, "fghij");
        PawnBlack pawnBlack2 = new PawnBlack("g6",board);
        Elephant elephantRed4 = new Elephant("h4",board, Type.Red, "abcde");
        board.items = new Item[]{pawnBlack, pawnBlack2,elephantBlack3,elephantBlack3};
        Assertions.assertFalse(elephantBlack3.canMove("g5"));
        Assertions.assertFalse(elephantRed4.canMove("f7"));


        Elephant elephantRed = new Elephant("a3",board, Type.Red, "abcde");
        Assertions.assertTrue(elephantRed.canMove("c5"));
        Elephant elephantRed2 = new Elephant("a3",board, Type.Red, "abcde");
        Assertions.assertFalse(elephantRed2.canMove("c4"));
        Elephant elephantRed3 = new Elephant("a8",board, Type.Red, "abcde");
        Assertions.assertFalse(elephantRed3.canMove("c10"));

        Elephant elephantBlack = new Elephant("h3",board, Type.Black, "fghij");
        Assertions.assertTrue(elephantBlack.canMove("f1"));
        Elephant elephantBlack2 = new Elephant("g3",board, Type.Black, "fghij");
        Assertions.assertFalse(elephantBlack2.canMove("e1"));

    }
}