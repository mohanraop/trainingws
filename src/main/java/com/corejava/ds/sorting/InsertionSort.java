package com.corejava.ds.sorting;

public class InsertionSort implements  Sortting{

    @Override
    public void sort() {
        int temp;
        int tempIndex;
        for(int index=0;index<iList.size();index++){
            int secondayIndex=index;
            while (secondayIndex>0){
                if(iList.get(index)>iList.get(secondayIndex)){
                    temp=iList.get(index);
                    iList.set(index,iList.get(index));
                    iList.set(secondayIndex,temp);
                }
                secondayIndex--;
            }
            System.out.println(index+" round");
            iList.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        new  InsertionSort().sort();
        Sortting.print();
    }
}
