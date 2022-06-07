package datastructures.dictionary;

public class ArrayDictionary<K, V> implements IDictionary<K, V> {
    int size = 0;
    int capacity = 8;
    Entry<K,V>[] data; // array of unsorted entries

    // Constructor
    public ArrayDictionary() {
        // TODO take note, we cannot use generics with array init.
        data = (Entry<K, V>[]) new Entry[capacity];
    }


    public V add(K key, V value) {
        if (isFull()) doubleCapacity();

        // search array, if key exists, update the value
        int keyIndex = contains(key); // if key is not in the array, -1
        if (keyIndex != -1) {
            data[keyIndex].value = value;
        }
        else { // else, add a new entry to the array
            data[size] = new Entry<>(key, value);
            size++; // increase size only when adding new, not updating
        }
        return value;
    }


    private boolean isFull() { return size==capacity; }

    private void doubleCapacity(){
        capacity *= 2;
        Entry<K,V>[] tempArray = (Entry<K,V>[]) new Entry[capacity];
        for (int i = 0; i < size; i++) tempArray[i] = data[i];
        data = tempArray;
    }


    public V remove(K key) {
        return null;
    }

    public V getValue(K key) {
        int itemIndex = contains(key);
        if (itemIndex != -1) return data[itemIndex].value;
        return null;
    }

    // returns -1 if not found
    public int contains(K searchingKey) {
        for (int i = 0; i < size; i++) {
            if (data[i].key.equals(searchingKey)) return i;
        }
        return -1;
    }

    public int getSize() { return size; }

    class Entry<S, T> {
        S key;
        T value;
        Entry(S key, T value){
            this.key = key;
            this.value = value;
        }
    }



    public static void main(String[] args) {
        ArrayDictionary<String, Integer> grades = new ArrayDictionary<>();
        grades.add("Alice", 80);
        grades.add("Bob", 75);
        grades.add("Clair", 99);
        grades.add("Bob", 100); // updates

        System.out.println("Dict Size: " + grades.getSize());
        System.out.println("Value: " + grades.getValue("Bob"));
    }
}
