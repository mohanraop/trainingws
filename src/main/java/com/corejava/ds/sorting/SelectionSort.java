package com.corejava.ds.sorting;

public class SelectionSort implements Sortting{
    public static void main(String[] args) {
     new  SelectionSort().sort();
        Sortting.print();
    }

    @Override
    public void sort() {
        int min=0,index=0;
        boolean isSwaped=false;
        for(int i=0;i<iList.size();i++){
            min=iList.get(i);
            index=i;
            isSwaped=false;
            for(int j=i+1;j<iList.size();j++){
                if(min>iList.get(j)){
                    min=iList.get(j);
                    index=j;
                    isSwaped=true;
                }
            }
            if(min<iList.get(i)){
                iList.set(index,iList.get(i));
                iList.set(i,min);
            }
            System.out.println();
            System.out.println("round="+(i+1));
            iList.stream().map(val->val+" ").forEach(System.out::print);
            if(!isSwaped){
                break;
            }
        }
    }
}
