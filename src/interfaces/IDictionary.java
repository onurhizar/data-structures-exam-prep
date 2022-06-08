package interfaces;

/* TODO
public Iterator<K> getKeyIterator();
public Iterator<V> getValueIterator();
*/

public interface IDictionary<K, V> {
    public V add(K key, V value);
    public V remove(K key);
    public V getValue(K key);
    public int contains(K key);
    public int getSize();
}
