package datastructures;

/*
     Methods
------------------
void push(T item);
T pop();
T peek(); // returns last item without popping
int getLength();

*/
public class LinkedStack<T> {
    private int length = 0;
    Node<T> lastNode;

    public static class Node<T> {
        T data;
        Node<T> previous;

        public Node(T data){this.data = data;}
    }

    public LinkedStack(){
        lastNode = null;
    }

    public void push(T newData){
        Node<T> tempNode = new Node<>(newData);
        if (length == 0) lastNode = tempNode;
        else {
            tempNode.previous = lastNode;
            lastNode = tempNode;
        }
        length++;
    }

    public T pop(){
        Node<T> removedNode = lastNode;
        lastNode = removedNode.previous;
        length--;
        return removedNode.data;
    }

    public boolean isEmpty() { return length==0; }

    public T peek(){ return lastNode.data; }

    public int getLength() { return length; }

    // displays the stack in reverse order without changing the order after displaying
    public void displayReverse(){
        LinkedStack<T> temp = new LinkedStack<>();
        System.out.println("\nREVERSE:\n---------------");

        // transfer from main to temp stack
        while (!isEmpty()) temp.push(pop());

        // transfer from temp to main stack, order remains same
        while (!temp.isEmpty()) {
            T current = temp.pop();
            push(current);
            System.out.println(current.toString());
        }
    }


    public static void main(String[] args) {
        // TESTING
        LinkedStack<String> papers = new LinkedStack<>();
        papers.push("Alice's Paper");
        papers.push("Brooks's Paper");
        papers.push("Carol's Paper");
        papers.push("David's Paper");

        System.out.println("Length: "+papers.getLength());
        System.out.println(papers.pop());
        System.out.println(papers.pop());
        System.out.println("Length: "+papers.getLength());

        papers.displayReverse();
    }
}
