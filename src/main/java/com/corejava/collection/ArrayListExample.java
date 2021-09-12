package com.corejava.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Integer>  integerList =  new ArrayList<>();
        integerList.add(10);
        integerList.add(3);
        integerList.add(2);
        integerList.add(1);
        System.out.println(integerList.add(5));
        System.out.println("Printing list");
        integerList.forEach(System.out::println);

        System.out.println("removing at index");
        System.out.println(integerList.remove(1));
        integerList.forEach(System.out::println);
        System.out.println("removing at Integer objet");
        System.out.println(integerList.remove(new Integer(1)));
        integerList.forEach(System.out::println);

        List myList = new ArrayList();
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        List chkList = Collections.checkedList(myList, String.class);
        System.out.println("Checked list content: "+chkList);
        //you can add any type of elements to myList object
        myList.add(10);
        //you cannot add any type of elements to chkList object, doing so throws ClassCastException
        chkList.add(10); //throws ClassCastException
    }
}
