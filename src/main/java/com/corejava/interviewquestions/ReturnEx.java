package com.corejava.interviewquestions;

public class ReturnEx {
    public static int fun() {
        System.out.println("A");
        try {
            System.out.println("B");
            int j=99/0;
            return 1;
        }catch(ArithmeticException e){
            System.out.println("AEE");
            return 2;
        }
       // System.out.println("test");
        catch(Exception e){
            System.out.println("E");
            return 2;
        }
        //System.out.println("return");
        //return 10;
    }

    public static void fun2() {
        System.out.println("A");
        try {
            System.out.println("B");
            int j=99/0;
        }catch(ArithmeticException e){
            System.out.println("AEE");
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("E");
        }
        finally {
            System.out.println("Finally");
        }
    }

    public static void main(String[] args) {
        fun();
        fun2();
        System.out.println("end of main");
    }
}
