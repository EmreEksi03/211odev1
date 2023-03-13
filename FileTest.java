import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @Test
    void save_binary() {
        Game g = GameMother.getGame();
        Item[] temp = g.board.createCopy();
        Assertions.assertDoesNotThrow(() -> g.save_binary("out.binary"));
        g.board.items = null;
        Assertions.assertDoesNotThrow(() -> g.load_binary("out.binary"));
        assertEquals(3, g.board.items.length);
        Assertions.assertArrayEquals(g.board.items,temp);
    }

    @Test
    void save_text() {
        Game g = GameMother.getGame();
        Assertions.assertDoesNotThrow(() -> g.save_text("out.txt"));
        g.board.items = null;
        Assertions.assertDoesNotThrow(() -> g.load_text("out.txt"));
        assertEquals(3, g.board.items.length);
    }

    @Test
    void load_text() {
    }

    @Test
    void load_binary() {
    }
}