import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChariotTest {

    @Test
    void move() {
    }

    @Test
    void canMove() {
        Board board = new Board();
        PawnBlack pawnBlack = new PawnBlack("g5",board);
        PawnBlack pawnBlack2 = new PawnBlack("h2",board);
        //PawnBlack pawnBlack3 = new PawnBlack("g5",board);
        Chariot chariotBlack = new Chariot("h5",board, Type.Black);
        Chariot chariotBlack2 = new Chariot("h3",board, Type.Black);
        Chariot chariotBlack3 = new Chariot("i3",board, Type.Black);
        board.items = new  Item[] {pawnBlack,pawnBlack2,chariotBlack2,chariotBlack};
        Assertions.assertFalse(chariotBlack.canMove("f5"));
        Assertions.assertFalse(chariotBlack2.canMove("h1"));
        Assertions.assertTrue(chariotBlack3.canMove("i7"));
        Assertions.assertTrue(chariotBlack3.canMove("j3"));

        board = new Board();
        PawnRed pawnRed = new PawnRed("d5",board);
        PawnRed pawnRed2 = new PawnRed("b6",board);
        Chariot chariotRed = new Chariot("c5",board, Type.Red);
        Chariot chariotRed2 = new Chariot("b3",board, Type.Red);
        board.items = new Item[]{pawnRed,pawnRed2,chariotRed2,chariotRed};

        Assertions.assertFalse(chariotRed.canMove("e5"));
        Assertions.assertFalse(chariotRed2.canMove("b7"));
    }
}