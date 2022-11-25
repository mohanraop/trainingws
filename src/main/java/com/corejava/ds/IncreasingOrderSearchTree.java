package com.corejava.ds;

import java.util.Stack;

public class IncreasingOrderSearchTree {
    Node prev,head,curr;
    public Node recursive(Node root){
        if(root ==null) return root;
        recursive(root.left);

        if(head==null)head=root;

        if(prev!=null){
            prev.right=root;
            root.left =null;
        }
        prev =  root;
        if(prev.right!=null)
            recursive(prev.right);
        return head;
    }

    public Node stack(Node root){
        Stack<Node> st = new Stack<>();
        if(root ==null) return root;
        while(root!=null || !st.isEmpty()) {
            while (root.left != null) {
                st.push(root);
                root = root.left;
            }

            if (head == null) head = root;

            if (prev != null) {
                prev.right = root;
                root.left = null;
            } else
                prev = root;
            curr = st.pop();
            if (curr.right != null)
                root = curr.right;
        }
        return head;
    }
}
