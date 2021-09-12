package com.collection;

import java.util.HashMap;
import java.util.Map;

class LRU{
    volatile int max_capcity;
    private Node header;
    private Node tail;
    private Map<Integer,Node> cache;


    public LRU(int max_capcity) {

        this.max_capcity = max_capcity;
        cache =  new HashMap<>(max_capcity);

    }

    public void put(int val){
        if(cache.containsKey(val)){
            Node node =  cache.get(val);
            remove(node);
            add(val);
        }else if(cache.size()==max_capcity){
            remove(header);
            add(val);
            cache.put(val, new Node(val));
        }

    }

    public void get(){

    }

    public void add(int val){
        Node node =  new Node(val);
        if(header==null){
            header = node;
            tail = header;
        }else{
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void remove(Node node){
        if(header ==  tail){
            header=tail=node=null;
        }else{
            Node tnode=node.previous;
            tnode.next = node.next;
            tnode.next.previous=tnode;
            node=null;
        }
    }

}

class Node{
    Integer val;
    Node next=null;
    Node previous=null;
    Node(int val){
        this.val =val;
    }
}

public class LRUImplimentation {
    public static void main(String[] args) {

    }
}
