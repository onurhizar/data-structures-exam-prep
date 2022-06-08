package nodes;

public class LinearNode<T> {
    private T data;
    private LinearNode<T> next;

    public LinearNode(T data) { this.data = data; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public LinearNode<T> getNext() { return next; }
    public void setNext(LinearNode<T> next) { this.next = next; }
}
