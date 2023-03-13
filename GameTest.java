import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void play() throws GameException, GameExitException {

        Game game2 = new Game("r","b");
        Chariot chariotBlack1 = new Chariot("g5",game2.board,Type.Black);
        Chariot chariotBlack2 = new Chariot("g6",game2.board,Type.Black);
        Chariot chariotBlack3 = new Chariot("g3",game2.board,Type.Black);
        Chariot chariotBlack4 = new Chariot("f3",game2.board,Type.Black);
        Horse horseBlack = new Horse("a4",game2.board,Type.Black);
        General generalRed2 = new General("a5",game2.board,Type.Red.getPalace(), Type.Red);
        General generalBlack2 = new General("j5",game2.board,Type.Black.getPalace(), Type.Black);
        game2.board.items = new Item[]{horseBlack,chariotBlack1,chariotBlack2,chariotBlack3,chariotBlack4,generalBlack2,generalRed2};

        game2.playExited("a5","a4");
        Assertions.assertThrows(GameExitException.class, () -> game2.playExited("g3","g4"));


        Game game1 = new Game("Red","Black");
        game1.playExited("a2","c1");
        game1.playExited("j1","h1");
        game1.playExited("c2","j2");
        //game1.playExited("j3","h5");
        game1.playExited("g1","f1");
        game1.playExited("a4","b5");
        game1.playExited("h8","a8");
        game1.playExited("a9","a8");
        game1.playExited("j8","h9");
    }
    @Test
    void playExited2() throws GameException, GameExitException {
        Game g = GameMother.getGame();
        g.playExited("a1","c1");
        Assertions.assertThrows(GameException.class, () -> g.playExited("c1","d1"));
        Game game = new Game("Red","Black");
        Chariot chariotBlack = new Chariot("h5",game.board,Type.Black);
        Chariot chariotBlack2 = new Chariot("h6",game.board,Type.Black);
        General generalRed = new General("a5",game.board,Type.Red.getPalace(), Type.Red);
        General generalBlack = new General("j4",game.board,Type.Black.getPalace(), Type.Black);
        game.board.items = new Item[]{chariotBlack,chariotBlack2,generalBlack,generalRed};
        Assertions.assertThrows(GameException.class, () -> game.playExited("a5","a6"));


        Chariot chariotRed3 = new Chariot("g5",game.board,Type.Red);
        Chariot chariotRed4 = new Chariot("g6",game.board,Type.Red);
        Chariot chariotRed5 = new Chariot("g3",game.board,Type.Red);
        General generalRed2 = new General("a3",game.board,Type.Red.getPalace(), Type.Red);
        General generalBlack2 = new General("j5",game.board,Type.Black.getPalace(), Type.Black);
        game.board.items = new Item[]{chariotRed3,chariotRed4,chariotRed5,generalBlack2,generalRed2};
        Assertions.assertThrows(GameExitException.class, () -> game.playExited("g3","g4"));
    }
}