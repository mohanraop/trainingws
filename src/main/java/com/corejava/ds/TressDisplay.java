package com.corejava.ds;

public class TressDisplay {
    public static void main(String[] args) {
        BSTree bt = new BSTree();
        bt.addVal(10);
        bt.addVal(5);
        bt.addVal(15);
        bt.addVal(4);
        bt.addVal(6);
        bt.addVal(14);
        bt.addVal(16);
        bt.displayTree();
        bt.inOrder();
        // bt.displayLeftView();
        //bt.displayRightView();
    }
}

class Node{
    public Integer val;
    public Node left, right;
    Node(Integer val){
        this.val = val;
        left=right=null;
    }
}

class BSTree{
    Node rn;
    public void inOrder(){
        inOrder(rn);
    }

    private void inOrder(Node node){
        if(node==null)
            return;
        inOrder(node.left);
        System.out.printf("%s ", node.val);
        inOrder(node.right);

    }
    public  void displayRightView(){
        displayRightView(rn);
    }
    private  void displayRightView(Node rn){
        if(rn == null)
            return;
        if(rn.right!=null){
            System.out.println(rn.right.val);
            displayRightView(rn.right);
        }
        if(rn.left!=null)
            displayRightView(rn.left);
        return;
    }

    public  void displayLeftView(){
        displayLeftView(rn);
    }
    private   void displayLeftView(Node rn){
        if(rn == null)
            return;
        if(rn.right!=null)
            displayLeftView(rn.right);
        if(rn.left!=null) {
            System.out.println(rn.left.val);
            displayLeftView(rn.left);
        }
        return;
    }
    public  void displayTree(){
        displayTree(rn);
    }
    private   void displayTree(Node rn){
        if(rn == null)
            return;
        System.out.println( rn.val      );
        displayTree(rn.right);
        displayTree(rn.left);

        return;
    }

    public void addVal(Integer val){
        if(rn==null) {
            rn = new Node(val);
        }else{
            Node n = rn ;
            while(true){
                if(n.val>val){
                    if(n.left == null){
                        n.left =new Node(val);
                        break;
                    }else{
                        n=n.left;
                    }
                }else{
                    if(n.right == null){
                        n.right =new Node(val);
                        break;
                    }else{
                        n=n.right;
                    }
                }
            }
        }
    }

}