package com.corejava.interviewquestions;

import com.corejava.ds.LinkedList;
import com.corejava.ds.Node;

import java.util.ArrayList;
import java.util.List;

public class NthNodeFromEndOfLinkedList {
    public static void main(String[] args) {
        //LinkedList: 1->2->3->4->5->6->7->8->9
        Node head = LinkedList.constructLinkedList();
        System.out.println("Input : ");
        LinkedList.printList(head);
        System.out.println("removeNthFromEnd : "+2);
        head = removeNthFromEnd_(head,2);
        //removeNthFromEnd_(head,2);
        System.out.println("Result : ");
        LinkedList.printList(head);

        System.out.println("Input : ");
        head = LinkedList.constructLinkedList();
        LinkedList.printList(head);
        System.out.println("removeNthFromEnd : "+9);
        head =removeNthFromEnd_(head,9);
        System.out.println("Result : ");
        LinkedList.printList(head);

        System.out.println("Input : ");
        head = LinkedList.constructLinkedList();
        LinkedList.printList(head);
        System.out.println("removeNthFromEnd : "+5);
        head =removeNthFromEnd_(head,5);
        System.out.println("Result : ");
        LinkedList.printList(head);

        //System.out.println("2 node from last is "+getNthFromLast(head,2));

        head = new Node(1);
        System.out.println("Input : ");
        LinkedList.printList(head);
        System.out.println("removeNthFromEnd : "+1);
        head = removeNthFromEnd_(head,1);
        System.out.println("Result : ");
        LinkedList.printList(head);


        head = new Node(1);
        LinkedList.addVal(head,2);
        System.out.println("Input : ");
        LinkedList.printList(head);
        System.out.println("removeNthFromEnd : "+1);
        head = removeNthFromEnd_(head,1);
        System.out.println("Result : ");
        LinkedList.printList(head);

        head = new Node(1);
        LinkedList.addVal(head,2);
        System.out.println("Input : ");
        LinkedList.printList(head);
        System.out.println("removeNthFromEnd : "+2);
        head = removeNthFromEnd_(head,2);
        System.out.println("Result : ");
        LinkedList.printList(head);
    }

    static int  getNthFromLast(Node head, int n)
    {
        // Your code here
        List<Integer> list = new ArrayList();
        while(head!=null){
            list.add(head.val);
            head = head.right;
        }
        int index =  list.size() - n;
        if (index>-1){
            return list.get(index);
        }
        return -1;
    }


    public static Node removeNthFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; i++) {
            if (fast.right == null) {
                // If n is equal to the number of nodes, delete the head node
                if (i == n - 1) {
                    head = head.right;
                }
                return head;
            }
            fast = fast.right;
        }
        while (fast.right != null) {
            fast = fast.right;
            slow = slow.right;
        }
        if (slow.right != null) {
            slow.right = slow.right.right;
        }
        return head;
    }
    public static Node removeNthFromEnd_(Node head, int n) {
        // Two pointers - fast and slow
        Node slow = head;
        Node fast = head;
        int counter =0 ;
        // Move fast pointer n steps ahead

        // Loop until we reach to the end.
        // Now we will move both fast and slow pointers
        while (fast!=null && fast.right != null) {
            if (counter<n) {
                if (fast.right == null) {
                    // If n is equal to the number of nodes, delete the head node
                    if (counter == n - 1) {
                        head = head.right;
                    }
                    return head;
                }

                fast = fast.right;
            }else {
                slow = slow.right;
                fast = fast.right;
            }
            counter++;
        }
        // Delink the nth node from last
        if(counter<n){
            slow = slow.right;
            head = slow;
        }else if (slow.right != null) {
            slow.right = slow.right.right;
        }else{
            head =  null;
        }
        return head;
    }
}
