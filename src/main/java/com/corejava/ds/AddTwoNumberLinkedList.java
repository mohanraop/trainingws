package com.corejava.ds;

public class AddTwoNumberLinkedList {
    public Node addList(Node l1Root,Node l2Root){
        if(l1Root==null || l2Root == null){
            return null;
        }
        Node l3Root=null,root=null,curr=null;
        int carry=0;
        while(l1Root!=null && l2Root != null){
            int val =  l1Root.val + l2Root.val+carry;
            if(val>10){
                val = val%10;
                carry = val/10;
            }
            curr = new Node(val);
             curr.right = root;
             root=curr;
             l1Root=l1Root.right;
             l2Root=l2Root.right;
        }
        if (carry>0){
            curr = new Node(carry);
            curr.right = root;
            root=curr;
        }
        return root;
    }
}
