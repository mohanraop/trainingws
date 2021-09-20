package com.corejava.interviewquestions;

import java.io.IOException;

class Parent {
    public void metd()throws Exception{
        System.out.println("test Parent");
    }
}
public class OverrideExcep extends Parent{
    public void metd()throws IOException{
        System.out.println("test Child");
    }

    public static void main(String[] args) throws Exception {
        Parent oe=new OverrideExcep();
        oe.metd();
    }
}
