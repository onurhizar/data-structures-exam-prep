package datastructures.iterators;

import interfaces.Iterator;

import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    // Attributes
    private int length;   // number of elements in collection
    private int current;  // current position in the iteration
    private T[] items;    // items in the collection

    // Constructor
    public ArrayIterator(T[] collection){
        items = collection; // takes reference address of array on RAM
        length = collection.length;
        current = 0;
    }

    public boolean hasNext() {
        return current < length;
    }

    // returns next element in the iteration
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        return items[current++]; // current index increases before exiting method scope
    }

    public void remove() { // removes the last passed item
        T removed = items[current-1];
        // swipe remains to fill the gap at current index
        for (int i = current; i < length; i++) {
            items[i-1] = items[i];
        }
        items[length-1] = null; // remove the last item, it already swiped to left
        length--; // change the ending index

        /* since length is changed, now current means current+1, so we need to
           decrease it so that it can point the same item as before  */
        current--;
    }


    public static void main(String[] args) {
        // TESTING
        String[] names = {"Alice", "Bob", "Carol", "David", "Eva"};
        ArrayIterator<String> iter = new ArrayIterator<>(names);

        while (iter.hasNext()) {
            String current = iter.next();
            iter.remove();
            System.out.println(current);
        }

        // note that, array length is same, but it is filled with null values
        System.out.println("\nItems on the array:");
        for (String name: names) System.out.println(name);
    }
}
