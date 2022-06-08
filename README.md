# CENG112 Final Exam Preparation

[Jump to personal notes](#personal-notes)

## Others
* Generics
* Iterator
* Comparable
* Recursion


## Main Data Structures
* Bag
* List ✅ [LinkedList](/src/datastructures/LinkedList.java)
* Queue ✅ [LinkedQueue](/src/datastructures/LinkedQueue.java)
* Deque (Double Ended Queue)
* PriorityQueue
* Stack ✅ [LinkedStack](/src/datastructures/LinkedStack.java)
* Tree & BST ✅ [BinaryTree](/src/datastructures/tree/BinaryTree.java)
* Dictionary ✅ [LinkedDictionary](/src/datastructures/dictionary/LinkedDictionary.java)
* HashMap (hashing, hash table?)

Methods of HashMap: put, get, remove, clear, size


<h2 id="personal-notes"> Personal Notes </h2>

Iterate over items with for loop syntax:
```
for (String item : strArray) {
  System.out.println(item);
}
```
<hr>

While creating array with generics, we use casting as like:

`data = (Entry<K, V>[]) new Entry[capacity];`
<hr>

Init 2 variables in one line, also init them in for loop
```
char ch[] = str.toCharArray();
int i, sum; // init 2 variables in one line
for (sum=0, i=0 ; i<length ; i++){ ...
```
<hr>

Each object has a hashCode method `myOby.hashCode();`

The Dictionary class is the abstract parent of any class, 
such as Hashtable, which maps keys to value.

HashMap<K,V>: Hash table based implementation of the Map interface.

<hr>

## ADT Dictionary Specifications
* add(key, value)
* getValueIterator()
* remove(key)
* isEmpty()
* getValue(key)
* getSize()
* contains(key)
* clear()
* getKeyIterator()

But in java.utils.HashMap it uses 
* put(key, value)
* get(key)
* remove 
* clear 
* size
