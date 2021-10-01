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

