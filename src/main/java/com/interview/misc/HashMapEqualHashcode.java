package com.interview.misc;

import java.util.HashMap;

public class HashMapEqualHashcode {
    String key;

    @Override
    public int hashCode() {
        return key.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
       if(!(obj instanceof HashMapEqualHashcode)) {
           return false;
       }else {
           HashMapEqualHashcode other = (HashMapEqualHashcode) obj;
           return (key.equals(other.key));
       }
    }
    public static void main(String[] args) {
        HashMapEqualHashcode h = new HashMapEqualHashcode();
        h.key = "key";
        HashMap<HashMapEqualHashcode ,Integer> map = new HashMap<>();
        map.put(h,123);
        h.key = "abc";
        System.out.println( map.get(h));
        //what is the output
    }
}

/*
console.log('a');
settimeout(()=>console.log('b'),0);
-----
-----
-----
-----
console.log('c')

    acb--1
    */

