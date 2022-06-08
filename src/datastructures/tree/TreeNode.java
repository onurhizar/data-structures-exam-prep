package datastructures.tree;

import datastructures.LinkedList;

// General Tree Node which can have more than 2 children
public class TreeNode<T> {
    private T data;
    private LinkedList<TreeNode<T>> children;

    // Constructor
    public TreeNode(T data){
        this.data = data;
        children = new LinkedList<>();
    }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public boolean isLeaf(){ return children.getLength()==0; }

    public TreeNode<T> addChild(T newChild){
        return addChild(new TreeNode<>(newChild));
    }

    public TreeNode<T> addChild(TreeNode<T> newChild){
        children.add(newChild);
        return newChild; // returns added Node's reference address
    }

    public LinkedList<TreeNode<T>> getChildren() {
        return children;
    }



    public static void iterateAndPrint(TreeNode<String> rootNode){
        TreeNode<String> currentNode = rootNode;
        LinkedList<TreeNode<String>> children = currentNode.getChildren();
        int childrenCount = children.getLength();

        System.out.println(rootNode.getData().toString());

        if (!currentNode.isLeaf()) { // if node is not leaf, dig into it
            for (int i = 0; i < childrenCount; i++) {
                TreeNode<String> child = children.get(i);
                iterateAndPrint(child);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("/");
        TreeNode<String> homeFolder = root.addChild("/home");
        TreeNode<String> downloadsFolder = root.addChild("/downloads");

        homeFolder.addChild("DBD.exe");
        homeFolder.addChild("Todo.txt");
        homeFolder.addChild("song.mp3");

        downloadsFolder.addChild("Django Tutorial.mp4");
        downloadsFolder.addChild("Nodejs Tutorial.mp4");

        TreeNode.iterateAndPrint(root);
    }
}
