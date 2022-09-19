package com.corejava.interviewquestions;

import com.corejava.ds.LinkedList;
import com.corejava.ds.Node;

import java.util.ArrayList;
import java.util.List;

public class NthNodeFromEndOfLinkedList {
    public static void main(String[] args) {
        //LinkedList: 1->2->3->4->5->6->7->8->9
        Node head = LinkedList.constructLinkedList();
        System.out.println(getNthFromLast(head,2));
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
}
