import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void isCheck() throws GameException {
        Game game = new Game("A","B");
        Board board = new Board();
        Chariot chariot = new Chariot("b4",board,Type.Red);
        General general = new General("i4",board,"jih",Type.Black);
        General general2 = new General("b5",board,"abc",Type.Red);
        board.items = new Item[]{general,chariot,general2};
        game.board = board;
        Assertions.assertTrue(game.isCheck(Type.Black));
        Assertions.assertFalse(game.isCheck(Type.Red));
    }

    @Test
    void isCheckMate() throws GameException {
        Game game = new Game("A","B");
        Board board = new Board();
        Chariot chariot = new Chariot("b6",board,Type.Red);
        Chariot chariot2 = new Chariot("i7",board,Type.Red);
        Chariot chariot3 = new Chariot("i4",board,Type.Red);
        Chariot chariot4 = new Chariot("b5",board,Type.Red);
        General general = new General("j5",board,"jih",Type.Black);
        General general2 = new General("b2",board,"abc",Type.Red);
        board.items = new Item[]{general,chariot,general2,chariot2,chariot3,chariot4};
        game.board = board;
        Assertions.assertTrue(game.isCheckMate(Type.Black));
        Assertions.assertFalse(game.isCheckMate(Type.Red));
    }

    @Test
    void play() throws GameException {

        Game g = GameMother.getGame();
        g.play("a1","c1");
        Assertions.assertThrows(GameException.class, () -> g.play("c1","d1"));
        Game game = new Game("Red","Black");
        Chariot chariotBlack = new Chariot("h5",game.board,Type.Black);
        Chariot chariotBlack2 = new Chariot("h6",game.board,Type.Black);
        General generalRed = new General("a5",game.board,Type.Red.getPalace(), Type.Red);
        General generalBlack = new General("j4",game.board,Type.Black.getPalace(), Type.Black);
        game.board.items = new Item[]{chariotBlack,chariotBlack2,generalBlack,generalRed};
        Assertions.assertThrows(GameException.class, () -> game.play("a5","a6"));
        Chariot chariotRed3 = new Chariot("g5",game.board,Type.Red);
        Chariot chariotRed4 = new Chariot("g6",game.board,Type.Red);
        Chariot chariotRed5 = new Chariot("g3",game.board,Type.Red);
        General generalRed2 = new General("a3",game.board,Type.Red.getPalace(), Type.Red);
        General generalBlack2 = new General("j5",game.board,Type.Black.getPalace(), Type.Black);
        game.board.items = new Item[]{chariotRed3,chariotRed4,chariotRed5,generalBlack2,generalRed2};
        game.play("g3","g4");


        Game game1 = new Game("Red","Black");
        game1.play("a2","c1");
        game1.play("j1","h1");
        game1.play("c2","j2");
        //game1.play("j3","h5");
        game1.play("g1","f1");
        game1.play("a4","b5");
        game1.play("h8","a8");
        game1.play("a9","a8");
        game1.play("j8","h9");
    }
}