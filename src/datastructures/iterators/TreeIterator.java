package datastructures.iterators;

import interfaces.Iterator;
import datastructures.tree.TreeNode;

// TODO. First, need to change LinkedStack's Node system to fit here

public class TreeIterator<T> implements Iterator<T> {

    public TreeNode<T> root;


    public boolean hasNext() {
        return false;
    }

    public T next() {
        return null;
    }

    public void remove() {

    }
}
