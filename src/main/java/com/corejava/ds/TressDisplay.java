package com.corejava.ds;

import java.util.LinkedList;
import java.util.Queue;

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

         bt.postorderIterative();;

        System.out.println();
        Queue<Integer> qq = new LinkedList<>();
        qq.offer(10);
        qq.offer(20);
        System.out.println(qq.poll());

        // bt.displayLeftView();
        //bt.displayRightView();
    }
}

