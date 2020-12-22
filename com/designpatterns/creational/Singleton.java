package com.designpatterns.creational;

import java.io.Serializable;

public class Singleton {
    public static void main(String[] args) {
        Pattern p = Pattern.getInstance();
        p.setName("Singleton pattern");
        System.out.println(p.getName());
    }
}

 class Pattern implements Cloneable, Serializable {

    static final Pattern pattern = new Pattern();

     private String name;

     private Pattern(){}

     public static Pattern getInstance(){
         return pattern;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     @Override
     public Object clone(){
         throw new RuntimeException("Cloning is not supported");
     }

}