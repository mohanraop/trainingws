package com.corejava.ds;

import java.util.Stack;

class BSTree {
    Node rn;

    public void inOrder() {
        inOrder(rn);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.printf("%s ", node.val);
        inOrder(node.right);

    }

    public void displayRightView() {
        displayRightView(rn);
    }

    private void displayRightView(Node rn) {
        if (rn == null)
            return;
        if (rn.right != null) {
            System.out.println(rn.right.val);
            displayRightView(rn.right);
        }
        if (rn.left != null)
            displayRightView(rn.left);
        return;
    }

    public void displayLeftView() {
        displayLeftView(rn);
    }

    private void displayLeftView(Node rn) {
        if (rn == null)
            return;
        if (rn.right != null)
            displayLeftView(rn.right);
        if (rn.left != null) {
            System.out.println(rn.left.val);
            displayLeftView(rn.left);
        }
        return;
    }

    public void displayTree() {
        displayTree(rn);
    }

    private void displayTree(Node rn) {
        if (rn == null)
            return;
        System.out.println(rn.val);
        displayTree(rn.left);
        displayTree(rn.right);
    }

    public void addVal(Integer val) {
        if (rn == null) {
            rn = new Node(val);
        } else {
            Node n = rn;
            while (true) {
                if (n.val > val) {
                    if (n.left == null) {
                        n.left = new Node(val);
                        break;
                    } else {
                        n = n.left;
                    }
                } else {
                    if (n.right == null) {
                        n.right = new Node(val);
                        break;
                    } else {
                        n = n.right;
                    }
                }
            }
        }
    }

    public int heightOftTree(){
        return heightOftTree(rn);
    }

    private int heightOftTree(Node rn) {
        if(rn==null)
            return 0;
        return heightOftTree(rn.left);
    }

    public void sumTree(){
        if(sumTree(rn)==1){
            System.out.println("This tree is a sum tree");
        }else{
            System.out.println("This tree is not a sum tree");
        }
    }

    private int isLeafNode(Node n){
        if(n==null)
            return 0;
        if(n.left==null && n.right==null)
            return 1;
        return 0;
    }

    public  void postorderIterative()
    {
        System.out.println();
        Node root = rn;
        // return if the tree is empty
        if (root == null) {
            return;
        }

        // create an empty stack and push the root node
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        // create another stack to store postorder traversal
        Stack<Integer> out = new Stack<>();

        // loop till stack is empty
        while (!stack.empty())
        {
            // pop a node from the stack and push the data into the output stack
            Node curr = stack.pop();
            out.push(curr.val);

            // push the left and right child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (curr.right != null) {
                stack.push(curr.right);
            }
        }

        // print postorder traversal
        while (!out.empty()) {
            System.out.print(out.pop() + " ");
        }
    }

    private int sumTree(Node rn) {
        int rsum=0,lsum=0;
        if (rn==null)
            return 1;
        if (isLeafNode(rn)==1)
            return 1;
        if(sumTree(rn.left)==1 && sumTree(rn.right)==1){
            if(isLeafNode(rn.right)==1)
                rsum=rn.right.val;
            else if(rn.right!=null)
                rsum = 2*rn.right.val;
            if(isLeafNode(rn.left)==1)
                lsum=rn.left.val;
            else if(rn.left!=null)
                lsum = 2*rn.left.val;

            if(rn.val==rsum+lsum)
                return 1;
        }
       return 0;
    }


}
