package com.ds.sorting;

import java.util.function.Supplier;

public class BubbleSort implements Sortting{
    //Worst case : o(n^2)
    //Average case: o(n)
    public static void main(String[] args) {
        Supplier<BubbleSort> s = ()->new  BubbleSort();
        s.get().sort();
        Sortting.print();
    }

    public void sort(){
        int temp=0;
        for(int i=0;i<iList.size();i++){
            boolean isSwapped =false;
            for (int j=0;j<iList.size()-1;j++){
                if(iList.get(j)>iList.get(j+1)){
                    temp = iList.get(j+1);
                    iList.set(j+1,iList.get(j));
                    iList.set(j,temp);
                    isSwapped=true;
                }
            }

            System.out.println("round="+(i+1));
            iList.forEach(System.out::println);
            if (!isSwapped)
                break;
        }
    }
}