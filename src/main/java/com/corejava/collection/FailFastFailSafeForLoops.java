package com.corejava.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastFailSafeForLoops {
    public static void main(String[] args) {
        List<Integer> integerList =  new ArrayList<>();
        integerList.add(10);
        integerList.add(3);
        integerList.add(2);
        integerList.add(1);
        int index=0;
        //fail safe
        for (;index<integerList.size();index++){
            System.out.println(integerList.get(index));
            if(index==2){
                integerList.add(1);
            }
        }
        //fail fast
        integerList.stream().forEach(e->{
            System.out.println(e);
            integerList.add(10);
        });
        //fail fast
        integerList.forEach(e->{
            System.out.println(e);
            integerList.add(10);
        });
        //fail fast
        Iterator itr= integerList.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
            integerList.add(10);
        }

        //fail fast
        index=0;
        for (int temp:integerList){
            index++;
            System.out.println(integerList.get(index));
            if(index==2){
                integerList.remove(1);
            }
        }
    }
}
