package com.threads;

public class ThreadDeadLock {
    public static void main(String[] args) throws Exception {
        Stack s1 = new Stack(10);
        //s1.push("1");
        //System.out.println(s1.pop());
        Thread t1 = new Thread(()->{
            try {
                s1.push("test");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                System.out.println(s1.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        System.out.println("completed");
    }
}


class Stack{
    private String ele[];
    int index;
    Object l1= new Object();
    Object l2= new Object();

    Stack(int size){
        ele = new String[size];
    }

    public void push(String element) throws Exception {
        System.out.println(Thread.currentThread().getName());
        if(index>= ele.length){
            throw new Exception("can not push more elements");
        }
        synchronized (l1) {
            ele[++index] = element;
            Thread.sleep(1000);
            pop();
        }
    }
    public String pop() throws Exception {
        System.out.println(Thread.currentThread().getName());
        if (index<0){
            throw new Exception("No elements in the stack");
        }
        synchronized (l2) {
            String element = ele[index--];
            System.out.println(element);
            Thread.sleep(1000);
            push("test");
             return element;
        }
    }
}