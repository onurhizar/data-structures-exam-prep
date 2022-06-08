package datastructures.tree;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> leftChild;
    public BinaryTreeNode<T> rightChild;

    // Constructor Chain
    public BinaryTreeNode(){ this(null); }

    public BinaryTreeNode(T data){ this(data, null, null); }

    public BinaryTreeNode(T data, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() { return data; }
    public void setData(T newData) { data = newData; }

    public BinaryTreeNode<T> getLeftChild() { return leftChild; }
    public BinaryTreeNode<T> getRightChild() { return rightChild; }

    public void setLeftChild(BinaryTreeNode<T> leftChild) { this.leftChild = leftChild; }
    public void setRightChild(BinaryTreeNode<T> rightChild) { this.rightChild = rightChild; }

    public boolean hasLeftChild() { return leftChild!= null; }
    public boolean hasRightChild() { return rightChild!= null; }

    public boolean isLeaf() { return leftChild==null && rightChild== null; }

}
