package com.corejava.ds.sorting;

public class InsertionSort implements  Sortting{

    @Override
    public void sort() {
        int temp;
        for(int index=1;index<iList.size();index++){
            int secondayIndex=index;
            temp=iList.get(secondayIndex);
            while (secondayIndex>0){
                if(iList.get(secondayIndex)>temp){
                    iList.set(secondayIndex+1,iList.get(secondayIndex));
                    iList.set(secondayIndex,temp);
                    break;
                }
                iList.set(secondayIndex+1,iList.get(secondayIndex));
                secondayIndex--;
            }
            System.out.println();
            System.out.println(index+" round");
            iList.stream().map(i->i+" ").forEach(System.out::print);
        }
    }

    public static void main(String[] args) {
        new  InsertionSort().sort();
        Sortting.print();
    }
}
