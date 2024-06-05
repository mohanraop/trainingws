package com.corejava.basic;

import java.util.LinkedList;

public class OutOfMemoryError {
    public static void main(String[] args) throws InterruptedException {
        String message = "Out of memory";
        LinkedList<String> list = new LinkedList<>();
        while (true){
            message +="mohan";
            Thread.sleep(100);
            list.add(message);
        }
    }
}
