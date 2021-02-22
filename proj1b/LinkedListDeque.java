public class LinkedListDeque<T> implements Deque<T> {
    private Node sentinel;
    private int size;

    private static class Node<T> {
        private T item;
        private Node next;
        private Node prev;

        Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(T item) {
        size++;
        Node node = new Node(item, sentinel.next, sentinel);
        sentinel.next.prev = node;
        sentinel.next = node;
    }

    @Override
    public void addLast(T item) {
        size++;
        Node node = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.next = node;
        sentinel.prev = node;
    }

    @Override
    public T removeLast() {
        if (!isEmpty()) {
            size--;
        }
        Node node = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return (T) node.item;
    }

    @Override
    public T removeFirst() {
        if (!isEmpty()) {
            size--;
        }
        Node node = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return (T) node.item;
    }

    @Override
    public void printDeque() {
        for (Node node = sentinel.next; node != sentinel; node = node.next) {
            System.out.print(node.item + " ");
        }
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            System.out.println("wrong index,please input the correct index");
        }
        Node node = sentinel.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return (T) node.item;
    }

    public T getRecursive(int index) {
        return (T) getNodeRecursive(index).item;
    }

    private Node getNodeRecursive(int index) {
        if (index == 0) {
            return sentinel.next;
        }
        return getNodeRecursive(index - 1).next;
    }
}
