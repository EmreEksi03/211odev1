import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeneralTest {

    @Test
    void move() {
    }

    @Test
    void canMove() throws GameException {
        Board board = new Board();
        PawnBlack pawnBlack = new PawnBlack("i4",board);
        General generalBlack = new General("i5",board, "ijh", Type.Black);
        General generalRed = new General("c4",board, "abc", Type.Red);

        board.items = new Item[]{pawnBlack,generalBlack,generalRed};
        Assertions.assertFalse(generalBlack.canMove("i4"));
        Assertions.assertFalse(generalBlack.canMove("h4"));
        Assertions.assertTrue(generalBlack.canMove("i6"));
        Assertions.assertTrue(generalBlack.canMove("h5"));
        board = new Board();
        board.items = new Item[]{generalBlack,generalRed};
        Assertions.assertFalse(generalBlack.canMove("i4"));

        board = new Board();
        board.items = new Item[]{generalBlack,generalRed};
        Assertions.assertFalse(generalRed.canMove("c5"));
        Assertions.assertTrue(generalRed.canMove("b4"));
        Assertions.assertFalse(generalBlack.canMove("i4"));

    }
}