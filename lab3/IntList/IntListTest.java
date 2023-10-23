import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IntListTest {

    /**
     * Performs a few arbitrary tests to see if the reverse method is correct
     */

    @Test(timeout = 1000)
    public void testReverse() {
        /* assertEquals for comparison of ints takes two arguments:
        assertEquals(expected, actual).
        if it is false, then the assertion will be false, and this test will fail.
        */

        IntList originList = IntList.of(3, 2, 1, 0);
        IntList reversedList = IntList.reverse(originList);
        IntList wantedList = IntList.of(0, 1, 2, 3);

        assertEquals(null, IntList.reverse(null));
        assertEquals(wantedList, reversedList);
        assertNotEquals(originList, reversedList);

    }
}