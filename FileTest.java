import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @Test
    void save_binary() {
        Game g = new Game("Red","Black");
        Item[] temp = g.board.createCopy();
        Assertions.assertDoesNotThrow(() -> g.save_binary("out.binary"));
        g.board.items = null;
        Assertions.assertDoesNotThrow(() -> g.load_binary("out.binary"));
        assertEquals(32, g.board.items.length);
        Assertions.assertArrayEquals(g.board.items,temp);
    }

    @Test
    void save_text() {
        //Game g = GameMother.getGame();
        Game g = new Game("Red","Black");
        Item[] temp = g.board.createCopy();
        Assertions.assertDoesNotThrow(() -> g.save_text("out.txt"));
        g.board.items = null;
        Assertions.assertDoesNotThrow(() -> g.load_text("out.txt"));
        Assertions.assertArrayEquals(g.board.items,temp);
        assertEquals(32, g.board.items.length);

    }

    @Test
    void load_text() {
    }

    @Test
    void load_binary() {
    }
}