package graphs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 06/08/2017
 */
public class Bag<T> implements Iterable<T> {

    private int size; //number of elements in bag
    private Node<T> first;  //beginning of bag

    //helper linked list class
    private static class Node<T> {

        private T item;
        private Node<T> next;
    }

    public Bag() {
        this.size = 0;
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void add(T item) {
        Node<T> oldFirst = this.first;
        this.first = new Node<T>();
        this.first.item = item;
        this.first.next = oldFirst;
        size++;
    }

    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
