package datastructures.tree;

// TODO, hasNext doesnt work

import interfaces.Iterator;
import datastructures.LinkedStack;

import java.util.NoSuchElementException;

public class BTInorderIterator<T> implements Iterator<T>{
    BinaryTreeNode<T> root;
    public LinkedStack<BinaryTreeNode<T>> traverseStack;

    public BTInorderIterator(BinaryTreeNode<T> root){
        this.root = root;
        traverseStack = new LinkedStack<>();
        moveLeft(root);
    }

    private void moveLeft(BinaryTreeNode<T> current){
        while (current != null) {
            traverseStack.push(current);
            current = current.getLeftChild();
        }
    }

    public boolean hasNext() {
        return !traverseStack.isEmpty();
    }

    public T next() {
        if (!hasNext()) throw new NoSuchElementException();

        BinaryTreeNode<T> current = traverseStack.pop();
        if (current.getRightChild() != null) moveLeft(current.getRightChild());

        return current.data;
    }

    public void remove() {

    }
}
