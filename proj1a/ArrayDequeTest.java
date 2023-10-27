import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void testEmpty() {
        ArrayDeque D = new ArrayDeque();
        assertEquals(0, D.size());
    }

    @Test
    public void testAddandSize() {
        ArrayDeque D = new ArrayDeque();
        D.addLast("a");
        assertEquals(1, D.size());
        D.addLast("b");
        D.addFirst("c");
        assertEquals(3, D.size());
    }
}