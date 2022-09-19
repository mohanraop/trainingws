package com.corejava.ds;

public class LinkedList {
    public static Node constructLinkedList(){
        Node head = new Node(1);
        addVal(head,2);
        addVal(head,3);
        addVal(head,4);
        addVal(head,5);
        addVal(head,6);
        addVal(head,7);
        addVal(head,8);
        addVal(head,9);
        return head;
    }
    public static void printList(Node head){
        while (true) {
            System.out.print(head.val +" - > ");
            if (head.right == null)
                break;
            head = head.right;
        }
        System.out.println();
    }
    static void addVal(Node head, int val){
        Node tmp = new Node(val);
        while (true){
            if(head.right == null)
                break;
            head = head.right;
        }
        head.right = tmp;
    }

}
