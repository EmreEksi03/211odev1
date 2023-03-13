import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void moveTest() {
    }

    @Test
    void canMoveTest() {

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
        PawnRed pawnred = new PawnRed("b2",board2);
        PawnRed pawnred2 = new PawnRed("c2",board2);
        PawnRed pawnred3 = new PawnRed("g7",board2);
        PawnRed pawnred4 = new PawnRed("g6",board2);
        board2.items = new Item[]{pawnred,pawnred2,pawnred3,pawnred4};
        Assertions.assertFalse(pawnred.canMove("c2"));
        Assertions.assertFalse(pawnred3.canMove("g6"));
        Assertions.assertTrue(pawnred3.canMove("g8"));
        Assertions.assertTrue(pawnred3.canMove("h7"));
    }
}