package datastructures;

import nodes.DoubleLinkedNode;

/*

        Methods
------------------------
void addToFront(T item);
void addToBack(T item);
T removeFront();
T removeBack();
T getFront();
T getBack();

*/

public class LinkedDeque<T> {
    DoubleLinkedNode<T> firstNode;
    DoubleLinkedNode<T> lastNode;

    // Constructor
    public LinkedDeque(){
        firstNode = null;
        lastNode = null;
    }

    public boolean isEmpty() { return firstNode==null && lastNode==null; }

    public T getFront() { return firstNode.data; }

    public T getBack() { return lastNode.data; }


    public void addToFront(T item){
        // first, create a new node in the RAM whose next links to the firstNode, previous=null
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(item, null, firstNode);

        if (isEmpty()) lastNode = newNode; // if chain is empty, first and last references the same node.
        else firstNode.previous = newNode;

        firstNode = newNode;
    }

    public void addToBack(T item){
        // first, create a new node in the RAM whose previous links to the lastNode, next=null
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(item, lastNode, null);

        if (isEmpty()) {
            firstNode = newNode; // if chain is empty, first and last references the same node.
        }
        else {
            lastNode.next = newNode;
        }
        lastNode = newNode;
    }

    public void printAllAscending(){
        System.out.println("Ascending Order: from first to last");
        DoubleLinkedNode<T> currentNode = firstNode;
        while (currentNode != null) {
            System.out.println(currentNode.data.toString());
            currentNode = currentNode.next;
        }
    }

    public void printAllDescending(){
        System.out.println("Descending Order: from last to first");
        DoubleLinkedNode<T> currentNode = lastNode;
        while (currentNode != null) {
            System.out.println(currentNode.data.toString());
            currentNode = currentNode.previous;
        }
    }

    public T removeFront(){
        T removedData = firstNode.data; // copy its value before passing
        firstNode = firstNode.next; // reassign the first node

        if (firstNode == null) lastNode=null; // if there is no item, flag lastNode to null to empty deque
        else firstNode.previous = null; // remove back connection to removed item

        return removedData;
    }

    public T removeBack(){
        T removedData = lastNode.data;
        lastNode = lastNode.previous; // reassign the last node

        if (lastNode==null) firstNode = null; // if there is no item, flag firstNode to null to empty deque
        else lastNode.next = null; // remove next connection to removed item

        return removedData;
    }



    public static void main(String[] args) {
        LinkedDeque<String> deque = new LinkedDeque<>();
        deque.addToBack("Alice");
        deque.addToBack("Bob");
        deque.addToBack("Carol");
        deque.addToBack("David");
        deque.addToFront("Aamir");

        String removed = deque.removeFront(); // removes Aamir
        deque.removeBack(); // removes David
        System.out.println("Removed item: "+removed);

        deque.printAllAscending();
        deque.printAllDescending();
    }

}
