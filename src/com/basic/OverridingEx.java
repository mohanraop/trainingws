package com.basic;

import java.io.IOException;

public class OverridingEx {
}
class A{
    public void m1(){
        System.out.println("public -A");
    }
     void m2(){
        System.out.println("default -A");
    }
    protected void m3(){
        System.out.println("protected -A");
    }
    private void m4(){
        System.out.println("private -A");
    }
    public void m5(Integer i){
        System.out.println("public + Integer -A");
    }
    public void m6(Integer i) throws  IOException{
        System.out.println("public + Integer -A");
    }
    public void m7(Integer i) throws  Exception{
        System.out.println("public + Integer -A");
    }
}
class B extends A{
    public void m1(){
        System.out.println("public -A & B");
    }
    public void m2(){
        System.out.println("default - A & public B ");
    }
    /*private void m3(){
        System.out.println("protected -A & not Private -B");
    }*/
    private void m4(){
        System.out.println("private -A");
    }
    public void m5(int i){
        System.out.println("public + Integer - A & public + int - b ");
    }
   /*
   'm6(Integer)' in 'B' clashes with 'm6(Integer)' in 'A';
   overridden method does not throw 'java.lang.Exception
   public void m6(Integer i) throws Exception {
        System.out.println("public + Integer -A");
    }
    */
   public void m7(Integer i) throws  IOException{
       System.out.println("public + Integer -A");
   }
}

