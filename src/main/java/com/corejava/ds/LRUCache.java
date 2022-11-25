package com.corejava.ds;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node{
        Node prev;
        Node next;

        int key;
        int val;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int cap = 0;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }

        return -1;
    }

    public void insert(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        node.prev = head;
        head.next = node;
        node.next = headNext;
        headNext.prev = node;
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public void put(int key, int value) {

        if(map.containsKey(key)){
            remove(map.get(key));
        }

        if(map.size()==cap){
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }
}