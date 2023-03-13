import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    void canMove() throws GameException {
        Board board = new Board();
        PawnRed pawnRed = new PawnRed("c4",board);
        PawnRed pawnRed2 = new PawnRed("a7",board);
        Horse horse = new Horse("a5",board,Type.Black);
        Horse horse2 = new Horse("a6",board,Type.Black);
        board.items = new Item[]{pawnRed,pawnRed2,horse,horse2};
        Assertions.assertTrue(horse.canMove("c4"));
        Assertions.assertTrue(horse.canMove("b3"));
        Assertions.assertFalse(horse2.canMove("b8"));
        PawnBlack pawnBlack = new PawnBlack("g3",board);
        Horse horse3 = new Horse("i2",board,Type.Black);
        board.items = new Item[]{pawnBlack,horse3};
        Assertions.assertFalse(horse3.canMove("g3"));
    }
}