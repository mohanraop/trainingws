package com.corejava.ds;

import java.util.Stack;

public class PostOrderTree {

    public static void main(String[] args)
    {
        Node rootNode = new Node(25);
        rootNode.left = new Node(35);
        rootNode.right = new Node(45);
        rootNode.left.left = new Node(55);
        rootNode.left.right = new Node(65);
        rootNode.right.left = new Node(75);
        rootNode.right.right = new Node(85);
        iterativePostOrder(rootNode);
    }

    private static void iterativePostOrder(Node rootNode) {
        Stack<Node> nStack = new Stack<>();
        Stack<Integer> out = new Stack<>();
        nStack.push(rootNode);
        Node currentNode = null;
        while (!nStack.isEmpty()){
            currentNode = nStack.pop();
            if(currentNode.left!=null){
                nStack.push(currentNode.left);
            }
            if(currentNode.right!=null){
                nStack.push(currentNode.right);
            }

            out.push(currentNode.val);
        }
        while (!out.isEmpty()){
            System.out.println(out.pop());
        }
    }
}
