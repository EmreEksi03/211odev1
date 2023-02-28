import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void moveTest() {
    }

    @Test
    void canMoveTest() {
        /*
        PawnRed pawnred = new PawnRed("a3");
        Assertions.assertTrue(pawnred.canMove("b3"));
        PawnRed pawnred2 = new PawnRed("a3");
        Assertions.assertFalse(pawnred2.canMove("c3"));
        PawnRed pawnred3 = new PawnRed("b3");
        Assertions.assertFalse(pawnred3.canMove("a3"));
        PawnRed pawnred4 = new PawnRed("f3");
        Assertions.assertTrue(pawnred4.canMove("f4"));
        PawnRed pawnred5 = new PawnRed("a3");
        Assertions.assertFalse(pawnred5.canMove("a4"));

        PawnBlack pawnblack = new PawnBlack("h3");
        Assertions.assertTrue(pawnblack.canMove("g3"));
        PawnBlack pawnblack2 = new PawnBlack("h3");
        Assertions.assertFalse(pawnblack2.canMove("h4"));
        PawnBlack pawnblack3 = new PawnBlack("b3");
        Assertions.assertTrue(pawnblack3.canMove("a3"));
        PawnBlack pawnblack4 = new PawnBlack("b3");
        Assertions.assertFalse(pawnblack4.canMove("a4"));

         */

        Board board = new Board();
        PawnBlack pawnblack = new PawnBlack("h3",board);
        PawnBlack pawnblack2 = new PawnBlack("g3",board);
        PawnBlack pawnblack3 = new PawnBlack("d5",board);
        PawnBlack pawnblack4 = new PawnBlack("d6",board);
        board.items = new Item[]{pawnblack,pawnblack2,pawnblack3,pawnblack4};
        Assertions.assertFalse(pawnblack.canMove("g3"));
        Assertions.assertFalse(pawnblack3.canMove("d6"));
        Assertions.assertTrue(pawnblack3.canMove("c5"));

        Board board2 = new Board();
        PawnRed pawnred = new PawnRed("b2",board);
        PawnRed pawnred2 = new PawnRed("c2",board);
        PawnRed pawnred3 = new PawnRed("g7",board);
        PawnRed pawnred4 = new PawnRed("g6",board);
        board.items = new Item[]{pawnred,pawnred2,pawnred3,pawnred4};
        Assertions.assertFalse(pawnred.canMove("c2"));
        Assertions.assertFalse(pawnred3.canMove("g6"));
        Assertions.assertTrue(pawnred3.canMove("g8"));
        Assertions.assertTrue(pawnred3.canMove("h7"));
    }
}