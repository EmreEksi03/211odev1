import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GuardianTest {

    @Test
    void move() {
    }

    @Test
    void canMove() {
        Board board = new Board();
        PawnRed pawnRed = new PawnRed("a6",board);

        Guardian guardianRed = new Guardian("b5",board, "abc", Type.Red);
        Guardian guardianRed2 = new Guardian("c6",board, "abc", Type.Red);

        board.items = new Item[]{pawnRed,guardianRed};

        Assertions.assertTrue(guardianRed.canMove("c4"));
        Assertions.assertFalse(guardianRed.canMove("a6"));
        Assertions.assertFalse(guardianRed2.canMove("d7"));

        Board board2 = new Board();
        PawnBlack pawnBlack = new PawnBlack("j4",board);

        Guardian guardianBlack = new Guardian("i5",board,"ijh",Type.Black);
        Guardian guardianBlack2 = new Guardian("h6",board,"ijh",Type.Black);

        board.items = new Item[]{pawnBlack,guardianBlack};

        Assertions.assertTrue(guardianBlack.canMove("j6"));
        Assertions.assertFalse(guardianBlack.canMove("j4"));
        Assertions.assertFalse(guardianBlack2.canMove("g7"));
    }
}