package com.corejava.jdk17.sealedClassInterface;

public sealed class Test3 extends SealedClass permits Test4 {
    @Override
    public void print() {
        System.out.println("sealed class Test3");
    }
}
