package com.corejava.ds.search;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LinearSearch {
    List<Integer> li = Arrays.asList(5,1,6,2,7,3,8,4,9);
    public void search(int input){
          if(li.stream().filter(i -> i == input).findAny().isPresent()){
              System.out.println("input element found");
          }else{
              System.out.println("input element not found");
          }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LinearSearch ls = new LinearSearch();
        ls.li.forEach(System.out::println);
        System.out.println("enter element to search:");
        ls.search(s.nextInt());
    }
}
