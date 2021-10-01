package com.corejava.ds;

public class SumTree {
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.rn = new Node(26);
        tree.rn.left = new Node(10);
        tree.rn.right = new Node(3);
        tree.rn.left.left = new Node(4);
        tree.rn.left.right = new Node(6);
        tree.rn.right.right = new Node(3);
        tree.displayTree();

        tree.sumTree();
    }
}
