import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testDequeGold() {
        StudentArrayDeque<Integer> testDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solDeque = new ArrayDequeSolution<>();

        String history = "\n";

        for (int i = 0; i < 100; i += 1) {
            double randomChoice = StdRandom.uniform();
            Integer testRemove = 0;
            Integer solRemove = 0;

            if (testDeque.isEmpty() || solDeque.isEmpty()) {
                int addNum = StdRandom.uniform(11);
                if (randomChoice < 0.5) {
                    testDeque.addLast(addNum);
                    solDeque.addLast(addNum);
                    history = history + "addLast(" + addNum + ")\n";

                } else {
                    testDeque.addFirst(addNum);
                    solDeque.addFirst(addNum);
                    history = history + "addFirst(" + addNum + ")\n";
                }
            }

            if (randomChoice < 0.25) {
                int addNum = StdRandom.uniform(11);
                testDeque.addLast(addNum);
                solDeque.addLast(addNum);
                history = history + "addLast(" + addNum + ")\n";
            } else if (randomChoice < 0.5) {
                int addNum = StdRandom.uniform(11);
                testDeque.addFirst(addNum);
                solDeque.addFirst(addNum);
                history = history + "addFirst(" + addNum + ")\n";
            } else if (randomChoice < 0.75) {
                testRemove = testDeque.removeFirst();
                solRemove = solDeque.removeFirst();
                history = history + "removeFirst()\n";
            } else {
                testRemove = testDeque.removeLast();
                solRemove = solDeque.removeLast();
                history = history + "removeLast()\n";
            }

            assertEquals(history, solRemove, testRemove);

        }

    }
}
