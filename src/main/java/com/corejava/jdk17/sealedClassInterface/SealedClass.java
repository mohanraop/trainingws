package com.corejava.jdk17.sealedClassInterface;

public sealed class SealedClass
        permits Test1, Test2, Test3 {

    public void print(){
        System.out.println("sealed class Frame");
    }
}

