package com.basic;

public class IntegerCace {
    public static void main(String[] args) {
        Integer i1=124;
        Integer i2=124;
        Integer i3=138;
        Integer i4=138;
        Integer i5 = new Integer(124);
        if((i1==i2)) {
            System.out.println("i1 and i2 are equal");
        }else{
            System.out.println("i1 and i2 are not equal");
        }
        if((i1==i5)) {
            System.out.println("i1 and i5 are equal");
        }else{
            System.out.println("i1 and i5 are not equal");
        }
        if((i3==i4)) {
            System.out.println("i3 and i4 are equal");
        }else{
            System.out.println("i3 and i4 are not equal");
        }
    }
}
