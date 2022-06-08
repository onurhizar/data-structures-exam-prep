package interfaces;

/**
 * A call of A.compareTo(B) should return
 * negative value : if A comes "before" than B
 * exactly 0      : if A and B considered "equal" in the ordering
 * positive value : if A comes "after" than B
 */
public interface Comparable<T> {
    public int compareTo(T other);
}
