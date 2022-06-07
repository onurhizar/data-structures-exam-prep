package datastructures;

/*
       Methods
---------------------
void add(T newItem);
Node<T> getNode();
T get(int index);
T remove(); // removes last item
T remove(int index);

*/

public class LinkedList<T> {
    int length = 0;
    Node<T> firstNode;

    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data){this.data = data;}
    }


    public void add(T newItem){
        Node<T> tempNode = new Node<>(newItem);

        if (length==0)
        {
            firstNode = tempNode;
        }
        else
        {
            // get last node
            Node<T> currentNode = firstNode;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            } // after the loop, currentNode is the last node in the chain
            currentNode.next = tempNode;
        }

        length++;
    }


    /**
     * Returns the Node at given index
     * @param index Starts from 0, to length-1
     */
    public Node<T> getNode(int index){
        if (index < 0 || index >= length) return null; // TODO THROW ERROR?

        Node<T> currentNode = firstNode;
        // to get index'th node we need to traverse next "index times"
        for (int i = 0; i < index; i++) currentNode = currentNode.next;
        return currentNode;
    }


    /**
     * Returns data of the given node index
     */
    public T get(int index) {
        return getNode(index).data;
    }


    /**
     * Index goes from 0 to length-1
     * @param index 0 means first item, length-1 means last item
     * @return the removed item
     */
    public T remove(int index) {
        if (index >= length) return null; // TODO THROW ERROR?
        else if (index == 0) {
            T itemData = firstNode.data;
            firstNode = firstNode.next;
            return itemData;
        }

        Node<T> previousNode = getNode(index-1); // previous node of removed
        Node<T> removedNode = previousNode.next;
        Node<T> nextNode = null; // the next node of removed
        if (removedNode.next != null) nextNode = removedNode.next;
        previousNode.next = nextNode; // new connection, from previous to next, jump
        length--;
        return removedNode.data;
    }


    /**
     * Removes the last item in the chain
     * @return removed item data
     */
    public T remove(){
        Node<T> currentNode = firstNode;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        } // the left currentNode is the last node whose next property is null
        return null; // TODO
    }


    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("onur");
        names.add("burak");
        names.add("enes");

        names.remove(1);
        System.out.println(names.get(0));
        System.out.println(names.get(1));
    }
}
