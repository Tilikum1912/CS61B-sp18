public class LinkedListDeque<T> {
    private class TNode {
        public T item;
        public TNode pre;
        public TNode next;

        public TNode(T i,  TNode p, TNode n) {
            item = i;
            pre = p;
            next = n;
        }

        public TNode(TNode p, TNode n) {
            pre = p;
            next = n;
        }
    }

    private TNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode(null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        TNode first = new TNode(item, sentinel, sentinel.next);
        sentinel.next.pre = first;
        sentinel.next = first;
        size += 1;
    }

    public void addLast(T item) {
        TNode last = new TNode(item, sentinel.pre, sentinel);
        sentinel.pre.next = last;
        sentinel.pre = last;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        TNode ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T x = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return x;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T x = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size -= 1;
        return x;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        TNode ptr = sentinel.next;
        while (index > 0) {
            ptr = ptr.next;
            index -= 1;
        }
        return ptr.item;
    }

    private T getRecursiveHelper(TNode start, int index) {
        if (index == 0) {
            return start.item;
        }
        return getRecursiveHelper(start.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

}