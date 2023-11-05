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
                testDeque.removeFirst();
                solDeque.removeFirst();
                history = history + "removeFirst()\n";
            } else {
                testDeque.removeLast();
                solDeque.removeLast();
                history = history + "removeLast()\n";
            }

            for (int j = 0; j < Math.min(solDeque.size(), testDeque.size()); j += 1)
            {
                assertEquals(history, solDeque.get(j), testDeque.get(j));
            }
        }

    }
}
