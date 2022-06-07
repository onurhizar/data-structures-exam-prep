package datastructures;

/*
     Methods
------------------
push(T item)
pop()
getLength()

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

    public int getLength() { return length; }


    public static void main(String[] args) {
        // TESTING
        LinkedStack<String> papers = new LinkedStack<>();
        papers.push("Alice's Paper");
        papers.push("Brooks's Paper");
        papers.push("Carol's Paper");

        System.out.println("Length: "+papers.getLength());
        System.out.println(papers.pop());
        System.out.println(papers.pop());
        System.out.println("Length: "+papers.getLength());
    }
}
