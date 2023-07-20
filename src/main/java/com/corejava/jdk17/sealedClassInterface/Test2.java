package com.corejava.jdk17.sealedClassInterface;

public non-sealed class Test2 extends SealedClass {
    @Override
    public void print() {
        System.out.println("non-sealed class Test2");
    }
}
