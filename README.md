# CENG112 Final Exam Preparation

[Jump to personal notes](#personal-notes)

TODO: Abstraction, public to private some attributes.

## Others
* Generics ✅
* Iterator ✅ 
[ArrayIterator](/src/datastructures/iterators/ArrayIterator.java) ,
[LinkedIterator](/src/datastructures/iterators/LinkedIterator.java)
* Comparable
* Recursion ✅ 
* Binary Search Tree ✅
* Circular Structure
* Comparable Interface (TODO)

## Main Data Structures
* Bag
* List ✅ [LinkedList](/src/datastructures/LinkedList.java)
* Queue ✅ [LinkedQueue](/src/datastructures/LinkedQueue.java)
* Deque ✅ [LinkedDeque](/src/datastructures/LinkedDeque.java)
* PriorityQueue
* Stack ✅ [LinkedStack](/src/datastructures/LinkedStack.java)
* Tree & BST ✅ [BinaryTree](/src/datastructures/tree/BinaryTree.java)
* Dictionary ✅ [LinkedDictionary](/src/datastructures/dictionary/LinkedDictionary.java)
* HashMap ✅ [HashMap](/src/datastructures/dictionary/HashMap.java)

Methods of HashMap: put, get, remove, clear, size


<h2 id="personal-notes">Personal Notes</h2>

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

<hr>

Both LinkedList and ArrayList has `iterator()` method 
which returns corresponding type iterator based on 
Iterator interface.
```
// ArrayList's iterator method
public Iterator<T> iterator(){
    return new ArrayIterator<T>(array);
}

// LinkedList's iterator method
public Iterator<T> iterator(){
    return new LinkedIterator<T>(firstNode);
}
```

As you see, both return the interface type, 
not implementations from it.

<hr>

## Deque
Java Deque Interface Methods
```
addFirst, offerFirst
addLast, offerLast
removeFirst, pollFirst
removeLast, pollLast
getFirst, peekFirst
getLast, peekLast
isEmpty, clear, size
```

<hr>

One line if else usage @ LinkedDeque:
```
if (isEmpty()) lastNode = newNode;
else firstNode.previous = newNode;
```

<hr>

Find successor: first take right, then go all left
```
// the first greater value in leaves after given node
public static Integer findSuccessor(BinaryTreeNode<Integer> current){
    if (current.isLeaf()) return current.data;
    current = current.getRightChild();
    while (!current.isLeaf()) current = current.getLeftChild();
    System.out.println("Successor value: "+current.data);
    return current.data;
}
```

Find Predecessor: first take left, then go all right
```
// the last lesser value in leaves before given node
public static Integer findPredecessor(BinaryTreeNode<Integer> current){
    if (current.isLeaf()) return current.data;
    current = current.getLeftChild(); // first, take left
    while (!current.isLeaf()) current=current.getRightChild(); // then all go right
    System.out.println("Predecessor value: "+current.data);
    return current.data;
}
```