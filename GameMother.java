public class GameMother {


    public static Game getGame() {
        Game g = new Game("Red","Black");
        General generalRed = new General("a5", g.board,"abc", Type.Red);
        General generalBlack = new General("j5", g.board,"jih", Type.Black);
        Chariot chariotRed1 = new Chariot("a1", g.board, Type.Red);
        g.board.items = new Item[]{chariotRed1,generalRed,generalBlack};
        return g;
    }
}
