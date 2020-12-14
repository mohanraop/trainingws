package com.basic;

public class OverloadMainMethod {
    //normal static method
    public static  void main(String args) {
        System.out.println("main");
    }
    //normal static method
    public static  void main(Object[] args) {
        System.out.println("main");
    }
   //normal static method
    public static void main(StringBuilder[] args) {
        System.out.println("main");
    }

    public static void main(String[] args) {
        System.out.println("main");
    }

   /*
   duplicate
   public static void main(String args[]) {
        System.out.println("main");
    }
   static void main(String[] args) {
        System.out.println("main");
    }
    private static void main(String[] args) {
       System.out.println("main");
   }
   static public void main(String[] args) {
       System.out.println("main");
   }
   public void main(String[] args) {
       System.out.println("main");
   }
   void main(String[] args) {
       System.out.println("main");
   }
   */


}
