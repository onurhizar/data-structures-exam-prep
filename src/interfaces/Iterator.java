package interfaces;

public interface Iterator<T> {
    public boolean hasNext();
    public T next();
    public void remove(); // removes the last element returned by the iterator
}
