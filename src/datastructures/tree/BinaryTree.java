package datastructures.tree;

import interfaces.Iterator;

public class BinaryTree<T> {
    BinaryTreeNode<T> root;

    // Constructors
    public BinaryTree() { root = null; }
    public BinaryTree(T rootData){ root = new BinaryTreeNode<>(rootData); }
    public BinaryTree(T rootData, BinaryTreeNode<T> leftTree, BinaryTreeNode<T> rightTree){
        root = new BinaryTreeNode<>(rootData, leftTree, rightTree);
    }

    public void setTree(T rootData) {
        root = new BinaryTreeNode<>(rootData);
    }

    public Iterator<T> iterator(){
        return new BTInorderIterator<>(root);
    }

    public void inorderTraverse(BinaryTreeNode<T> node){
        if (node != null) {
            inorderTraverse(node.getLeftChild());
            System.out.println(node.getData());
            inorderTraverse(node.getRightChild());
        }
    }

    public void preorderTraverse(BinaryTreeNode<T> node){
        if (node != null) {
            System.out.println(node.getData());
            inorderTraverse(node.getLeftChild());
            inorderTraverse(node.getRightChild());
        }
    }


    // counts occurrences in tree
    public int count(T searchingValue, BinaryTreeNode<T> rootNode){
        return count(searchingValue, rootNode, 0);
    }
    public int count(T searchingValue, BinaryTreeNode<T> rootNode, int count){
        return -1111; // TODO
    }


    public static void main(String[] args) {
        BinaryTreeNode<String> tree = new BinaryTreeNode<>("BOSS");
        tree.setLeftChild(new BinaryTreeNode<>("Sol Kol"));
        tree.setRightChild(new BinaryTreeNode<>("Sağ Kol"));

        BinaryTreeNode<String> solKol = tree.getLeftChild();
        BinaryTreeNode<String> sagKol = tree.getRightChild();

        solKol.setLeftChild(new BinaryTreeNode<>("Sol A"));
        solKol.setRightChild(new BinaryTreeNode<>("Sol B"));
        sagKol.setLeftChild(new BinaryTreeNode<>("Sağ A"));
        sagKol.setRightChild(new BinaryTreeNode<>("Sağ B"));

        BinaryTree<String> strTree = new BinaryTree<>();
        System.out.println("InOrder Traverse\n");
        strTree.inorderTraverse(tree);

        System.out.println("\nPreOrder Traverse\n");
        strTree.preorderTraverse(tree);

        Iterator<String> iter = strTree.iterator();
        while (iter.hasNext()) System.out.println(iter.next());
    }
}
