import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElephantTest {

    @Test
    void move() {
    }

    @Test
    void canMove() {
        Board board = new Board();

        PawnBlack pawnBlack = new PawnBlack("g5",board);
        ElephantBlack elephantBlack3 = new ElephantBlack("i3",board);
        PawnBlack pawnBlack2 = new PawnBlack("g6",board);
        ElephantRed elephantRed4 = new ElephantRed("h4",board);
        board.items = new Item[]{pawnBlack, pawnBlack2,elephantBlack3,elephantBlack3};
        Assertions.assertFalse(elephantBlack3.canMove("g5"));
        Assertions.assertFalse(elephantRed4.canMove("f7"));


        ElephantRed elephantRed = new ElephantRed("a3",board);
        Assertions.assertTrue(elephantRed.canMove("c5"));
        ElephantRed elephantRed2 = new ElephantRed("a3",board);
        Assertions.assertFalse(elephantRed2.canMove("c4"));
        ElephantRed elephantRed3 = new ElephantRed("a8",board);
        Assertions.assertFalse(elephantRed3.canMove("c10"));

        ElephantBlack elephantBlack = new ElephantBlack("h3",board);
        Assertions.assertTrue(elephantBlack.canMove("f1"));
        ElephantBlack elephantBlack2 = new ElephantBlack("g3",board);
        Assertions.assertFalse(elephantBlack2.canMove("e1"));

    }
}