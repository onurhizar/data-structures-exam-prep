package datastructures.iterators;

import interfaces.Iterator;
import nodes.LinearNode;

import java.util.NoSuchElementException;

public class LinkedIterator<T> implements Iterator<T> {
    LinearNode<T> current; // current position on the chain
    LinearNode<T> previous; // previous node of current (i-1)

    public LinkedIterator(LinearNode<T> collectionHeadNode){
        current = collectionHeadNode;
    }

    public boolean hasNext() {
        return (current != null);
    }

    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        T result = current.getData(); // copy value before passing
        previous = current;
        current = current.getNext(); // pass to next
        return result;
    }

    public void remove() {
        // TODO: needs to be fixed, removed next one, not passed one
        previous.setNext(current.getNext()); // remove connection, jump i-1 to i+1
    }


    public static void main(String[] args) {
        LinearNode<String> n1 = new LinearNode<>("Alice");
        LinearNode<String> n2 = new LinearNode<>("Barney");
        LinearNode<String> n3 = new LinearNode<>("Carol");
        LinearNode<String> n4 = new LinearNode<>("David");

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        Iterator<String> iter = new LinkedIterator<>(n1);

        while(iter.hasNext()) {
            String currentItem = iter.next();
            System.out.println(currentItem);
        }
    }
}
