import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanMovableTest {

    @Test
    void canMovableHorse() throws GameException {
        Board board = new Board();
        Horse d5Horse = new Horse("d5",board,Type.Black);
        PawnBlack e5Pawn = new PawnBlack("e5",board);
        PawnBlack c5Pawn = new PawnBlack("c5",board);
        PawnBlack d4Pawn = new PawnBlack("d4",board);
        PawnBlack d6Pawn = new PawnBlack("d6",board);
        board.items = new Item[]{d5Horse,e5Pawn,c5Pawn,d4Pawn,d6Pawn};
        Assertions.assertFalse(d5Horse.moveable());

        board.items = new Item[]{d5Horse,e5Pawn,c5Pawn,d4Pawn};
        Assertions.assertTrue(d5Horse.moveable());

        PawnBlack e7Pawn = new PawnBlack("e7",board);
        PawnBlack c7Pawn = new PawnBlack("c7",board);
        PawnBlack e3Pawn = new PawnBlack("e3",board);
        PawnBlack c3Pawn = new PawnBlack("c3",board);

        PawnBlack f4Pawn = new PawnBlack("f4",board);
        PawnBlack f6Pawn = new PawnBlack("f6",board);
        PawnBlack b4Pawn = new PawnBlack("b4",board);
        PawnBlack b6Pawn = new PawnBlack("b6",board);
        board.items = new Item[]{e7Pawn,c7Pawn,e3Pawn,c3Pawn,f4Pawn,f6Pawn,b4Pawn,b6Pawn};
        Assertions.assertFalse(d5Horse.moveable());
        board.items = new Item[]{e7Pawn,c7Pawn,e3Pawn,c3Pawn,f4Pawn,f6Pawn,b4Pawn};
        Assertions.assertTrue(d5Horse.moveable());
        board.items = new Item[]{c7Pawn,e3Pawn,c3Pawn,f4Pawn,f6Pawn,b4Pawn,b6Pawn};
        Assertions.assertTrue(d5Horse.moveable());
    }

    @Test
    void canMovableElephant() throws GameException {
        Board board = new Board();
        Elephant c5Elephant = new Elephant("c5",board,Type.Black,Type.Black.getHalf());

        PawnBlack e7Pawn = new PawnBlack("e7",board);
        PawnBlack e3Pawn = new PawnBlack("e3",board);
        PawnBlack a7Pawn = new PawnBlack("a7",board);
        PawnBlack a3Pawn = new PawnBlack("a3",board);
        board.items = new Item[]{c5Elephant,e7Pawn,e3Pawn,a7Pawn,a3Pawn};
        Assertions.assertFalse(c5Elephant.moveable());

        board.items = new Item[]{c5Elephant,e7Pawn,e3Pawn,a7Pawn};
        Assertions.assertTrue(c5Elephant.moveable());

    }


}