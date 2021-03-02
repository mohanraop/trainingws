package com.basic;

public class VariableScope {
    private int a=10;
    public int b=20;
    public void printValues(){
        int c=30;
        class inner{
            int d=40;
            private void cal(){
                int e=50;
                System.out.println(e);
                System.out.println(d);
                System.out.println(c);
                System.out.println(b);
                System.out.println(a);
            }
        }
    }
}
