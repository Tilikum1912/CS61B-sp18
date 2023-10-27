public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int max_size;

    /** constructor of empty ArrayDeque. */
    public ArrayDeque() {
        max_size = 8;
        array = (T[]) new Object[max_size];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private void spand() {
        int new_max_size = max_size * 2;
        T[] new_array = (T[]) new Object[new_max_size];
        nextFirst = nextLast - 1 + max_size;
        int first = nextFirst + 1;
        for (int i = 0; i < size; i++) {
            new_array[first] = array[nextLast];
            first = (first + 1 + new_max_size) % new_max_size;
            nextLast = (nextLast + 1 + max_size) % max_size;
        }
        array = new_array;
        max_size = new_max_size;
    }

    public void addFirst(T x) {
        if (size == array.length) {
            spand();
        }
        array[nextFirst] = x;
        nextFirst = (nextFirst - 1 + max_size) % max_size;
        size += 1;
    }

    public void addLast(T x) {
        if (size == array.length) {
            spand();
        }
        array[nextLast] = x;
        nextLast = (nextLast + 1 + max_size) % max_size;
        size += 1;
    }

    private void shrink() {
        int new_max_size = max_size / 2;
        T[] new_array = (T[]) new Object[new_max_size];
        int first = new_max_size / 2;
        int new_nextFirst = first - 1;
        for (int i = 0; i < size; i++) {
            new_array[first] = array[(nextFirst + 1 + max_size) % max_size];
            first = (first + 1 + new_max_size) % new_max_size;
            nextFirst = (nextFirst + 1 + max_size) % max_size;
        }
        array = new_array;
        max_size = new_max_size;
        nextFirst = new_nextFirst;
        nextLast = (nextFirst + size + 1 + max_size) % max_size;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T x = array[(nextFirst + 1 + max_size) % max_size];
        nextFirst = (nextFirst + 1 + max_size) % max_size;
        size -= 1;
        if (array.length >= 16 && size < array.length / 4) {
            shrink();
        }
        return x;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T x = array[(nextLast - 1 + max_size) % max_size];
        nextLast = (nextLast - 1 + max_size) % max_size;
        size -= 1;
        if (array.length >= 16 && size < array.length / 4) {
            shrink();
        }
        return x;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int ptr = nextFirst;
        while (index >= 0) {
            ptr = (ptr + 1 + max_size) % max_size;
            index -= 1;
        }
        return array[ptr];
    }

    public void printDeque() {
        int ptr = (nextFirst + 1 + max_size) % max_size;
        while (ptr != nextLast) {
            System.out.print(array[ptr] + " ");
            ptr = (ptr + 1 + max_size) % max_size;
        }
    }
}