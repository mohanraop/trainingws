package com.corejava.interviewquestions;

import com.corejava.ds.Node;

import java.util.*;

public class FindMiddleElementSingItter {
    public static void main(String[] args) {
        LinkedList<Integer> li = new LinkedList<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        li.add(5);

        Node root , last ;
        root = last = new Node(1);
        Node next = new Node(2);
        last.right = next;
        last = next;
        next = new Node(3);
        last.right = next;
        last = next;
        next = new Node(4);
        last.right = next;
        last = next;
        middleElementOld(root);
        middleElementNew(root);
        System.out.println();
        next = new Node(5);
        last.right = next;
        last = next;
        middleElementOld(root);
        middleElementNew(root);
    }
    public static void middleElementNew(Node fast){
         Node slow =fast;
        while (Objects.nonNull(fast.right)){
            fast = fast.right;
            if(Objects.nonNull(fast.right)){
                fast = fast.right;
                slow = slow.right;
            }
        }

        System.out.println("Middle element is "+slow.val);

    }
    public static void middleElementOld(Node next){
        int middle = 0;
        List<Integer> al = new ArrayList<>();
        while (Objects.nonNull(next)){
            al.add(next.val);
            next=next.right;
        }
        if(al.size()>0){
            if(al.size()<3)
                middle=al.get(0);
            else{
                middle = al.get(al.size()/2);
            }
        }
        System.out.println("Middle element is "+middle);

    }
}
