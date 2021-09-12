package com.basic;

import java.util.List;

public class ForLoops {
    public static void main(String[] args) {
        int i[] = new int[]{1,2,3,4};
        for(int index=0;index<i.length;index++){
            System.out.println(i[index]);
        }
        for (int temp:i){
            System.out.println(temp);
        }

    }
}
