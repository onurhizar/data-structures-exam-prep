package datastructures.dictionary;

/*

        Methods
-----------------------
T add(K key, V value);
T remove(K key);
T getValue(K key);
int contains(K key);
int getSize();

*/

public class LinkedDictionary<K, V> implements IDictionary<K,V> {
    int size = 0;
    Node<K,V> head;

    // Constructor
    public LinkedDictionary(){
        head = null;
    }

    /** Searches for given key, returns its value if exists, else, null */
    private Node<K, V> getNode(K key){
        Node<K, V> currentNode = head;
        while (currentNode != null){
            if (currentNode.key.equals(key)) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    public V add(K key, V value) {
        // if key already exists, update its value without increase size
        Node<K,V> tempNode = getNode(key);
        if (tempNode != null) { // update its value
            tempNode.value = value;
        } else { // add new item to chain, increase size
            Node<K,V> newNode = new Node<>(key, value);
            newNode.next = head;
            head = newNode;
            size++;
        }
        return value;
    }

    public V remove(K key) {
        Node<K, V> previousNode = null; // previous node of current node
        Node<K, V> currentNode = head;
        Node<K, V> removedNode = head;

        while (currentNode != null){ // traverse all nodes
            if (!currentNode.key.equals(key)) { // traverse until find the key
                previousNode = currentNode;
                currentNode = currentNode.next;
            } else { // when found the key, adjust links to remove searching item
                removedNode = currentNode;
                previousNode.next = removedNode.next; // connection jumps over removedItem
            }
        }
        return removedNode.value;
    }

    public V getValue(K key) { return getNode(key).value; }

    public int contains(K key) { // if not exists -1, else 1
        Node<K, V> node = getNode(key);
        if (node != null) return 1;
        return -1;
    }

    public int getSize() {
        return size;
    }

    class Node<Kk, Vv> {
        Kk key;
        Vv value;
        Node<Kk,Vv> next;

        Node(Kk key, Vv value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedDictionary<String, Integer> grades = new LinkedDictionary<>();
        grades.add("Ali", 80);
        grades.add("Bekir", 75);
        grades.add("Cemil", 99);
        grades.add("Bekir", 100); // updates

        System.out.println("Dict Size: " + grades.getSize());
        System.out.println("Value: " + grades.getValue("Bekir"));
    }
}
