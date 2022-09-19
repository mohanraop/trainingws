package com.corejava.interviewquestions;

import com.corejava.ds.LinkedList;
import com.corejava.ds.Node;

public class ReverseLinkedList {
    public static void main(String[] args) {
        //LinkedList: 1->2->3->4->5->6->7->8->9
        Node head = LinkedList.constructLinkedList();
         LinkedList.printList(head);
          head = reverseList(head);
        LinkedList.printList(head);

    }
    public static Node reverseList(Node head){
        Node head2 = null;
        while (true) {
             if(head==null)
                 break;
             Node temp = head;
             head = head.right;
             temp.right = head2;
             head2 = temp;
        }
        return head2;
    }
}
