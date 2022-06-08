package datastructures.tree;

import datastructures.tree.BinaryTreeNode;

public class BinarySearchTree {
    public BinaryTreeNode<Integer> root;
    int itemCount;

    // Constructors
    public BinarySearchTree(){
        this(null);
    }
    public BinarySearchTree(Integer rootValue){
        root = new BinaryTreeNode<>(rootValue);
        if (rootValue!= null) itemCount++;
    }

    // returns true if bst contains searchingItem value
    public static boolean bstSearch(BinaryTreeNode<Integer> rootNode, Integer searchingItem){
        if (rootNode == null) return false;
        int result = rootNode.data.compareTo(searchingItem);

        if (result == 0) return true; // item exists in tree
        else if (result < 0) return bstSearch(rootNode.getRightChild(), searchingItem);
        else if (result > 0) return bstSearch(rootNode.getLeftChild(), searchingItem);

        return false; // if it cannot find after digging in, returns false
    }


    // the last lesser value in leaves before given node
    public static Integer findPredecessor(BinaryTreeNode<Integer> current){
        if (current.isLeaf()) return current.data;
        current = current.getLeftChild(); // first, take left
        while (!current.isLeaf()) current=current.getRightChild(); // then all go right
        System.out.println("Predecessor value: "+current.data);
        return current.data;
    }

    // the first greater value in leaves after given node
    public static Integer findSuccessor(BinaryTreeNode<Integer> current){
        if (current.isLeaf()) return current.data;
        current = current.getRightChild(); // first, take right
        while (!current.isLeaf()) current = current.getLeftChild(); // then all go left
        System.out.println("Successor value: "+current.data);
        return current.data;
    }



    public static void main(String[] args) {
        BinarySearchTree grades = new BinarySearchTree(10);
        grades.root.setLeftChild(new BinaryTreeNode<>(5));
        grades.root.getLeftChild().setLeftChild(new BinaryTreeNode<>(1));
        grades.root.getLeftChild().setRightChild(new BinaryTreeNode<>(7));

        grades.root.setRightChild(new BinaryTreeNode<>(20));
        grades.root.getRightChild().setLeftChild(new BinaryTreeNode<>(15));
        grades.root.getRightChild().setRightChild(new BinaryTreeNode<>(30));

        boolean exists = BinarySearchTree.bstSearch(grades.root, 7);
        if (exists) System.out.println("item exists");

        BinarySearchTree.findSuccessor(grades.root);
        BinarySearchTree.findPredecessor(grades.root);

    }
}
