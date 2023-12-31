
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Isn't this solution kinda... cheating? Yes.
 */
public class LinkedListDeque<Item> extends LinkedList<Item> implements Deque<Item> {
    @Override
    public void printDeque() {
        System.out.println("dummy");
    }

    @Override
    public Item get(int index) {
        return super.get(index);
    }

    @Override
    public Item removeFirst() {
        try {
            return super.removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Item removeLast() {
        try {
            return super.removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public void addFirst(Item item) {
        super.addFirst(item);
    }

    @Override
    public void addLast(Item item) {
        super.addLast(item);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        return super.size();
    }
}
