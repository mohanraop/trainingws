package com.ds.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    List<Integer> li = Arrays.asList(5,1,6,2,7,3,8,4,9);
    public boolean search(int input){
        int left=0,mid=li.size()/2,right=li.size()-1;
        while(left<=right){
            if (li.get(mid) == input) {
                return true;
            }
            if(li.get(mid)>input) {
                right=mid-1;
            }else{
                left = mid+1;
            }
            mid =(left+right)/2;
        }
        return false;
    }

    public boolean recursiveSearch(int left,int mid,int right,int input){
        if(li.get(mid)==input){
            return true;
        }
        if(left<=right){
            if(li.get(mid)<input){
                return recursiveSearch(mid+1,(mid+1+right)/2,right,input);
            }else{
                return recursiveSearch(left,(mid-1+left)/2,mid-1,input);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinarySearch bs = new BinarySearch();
        bs.li.forEach(System.out::println);
        System.out.println("enter element to search:");
        Collections.sort(bs.li);
        int input =s.nextInt();
        boolean isFound = false;
        isFound = bs.search(input);
        isFound= bs.recursiveSearch(0,(bs.li.size())/2,bs.li.size()-1,input);
        if(isFound){
            System.out.println("input element found");
        }else{
            System.out.println("input element not found");
        }
    }
}
