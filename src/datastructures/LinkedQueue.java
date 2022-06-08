package datastructures;

/*
LIFO Structure : Last in First Out
New item enter from back, leaves from front.

       Methods
----------------------
void enqueue(T item);
T dequeue();
int getLength();
T getFront();
boolean isEmpty();
void clear();

*/

public class LinkedQueue<T> {
    private int length = 0;
    private Node<T> front;
    private Node<T> back;

    class Node<T> {
        T data;
        Node<T> next;
        public Node(T data) { this.data = data; }
    }

    // Constructor
    public LinkedQueue(){
        front = null;
        back = null;
    }

    public void enqueue(T newItem){
        Node<T> tempNode = new Node<>(newItem);
        if (length == 0) {
            front = tempNode;
            back = tempNode;
        }
        else
        {
            back.next = tempNode;
            back = tempNode;
        }
        length++;
    }

    public T dequeue(){
        if (length==0) return null; // TODO THROW ERROR?

        T removedData  = front.data;
        front = front.next;
        length--;
        return removedData;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");
        queue.enqueue("last");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("Left: "+queue.getLength());
    }
}
