package com.corejava.jdk17.sealedClassInterface;

public sealed interface SealeadInterface {
    public  void test1();
}

non-sealed interface ChaildInterface extends SealeadInterface{
    public  void test2();
}

class Test implements ChaildInterface{

    @Override
    public void test1() {

    }

    @Override
    public void test2() {

    }
}
