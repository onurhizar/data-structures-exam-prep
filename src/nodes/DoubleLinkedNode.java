package nodes;

// DoubleLinkedNode Structure : ( previousNodeReference | DATA | nextNodeReference )

public class DoubleLinkedNode<T> {
    public T data;
    public DoubleLinkedNode<T> previous;
    public DoubleLinkedNode<T> next;

    // Constructors
    public DoubleLinkedNode() { this(null,null,null); }
    public DoubleLinkedNode(T data) { this(data,null,null); }
    public DoubleLinkedNode(T data, DoubleLinkedNode<T> previous, DoubleLinkedNode<T> next){
        this.data = data;
        this.previous = previous;
        this.next = next;
    }
}
