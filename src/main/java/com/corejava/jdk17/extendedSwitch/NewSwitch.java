package com.corejava.jdk17.extendedSwitch;

import com.corejava.jdk17.sealedClassInterface.*;
import lombok.NonNull;

public class NewSwitch {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test(test1);
    }

    public static void test(@NonNull SealedClass sc){
        switch (sc){
            case Test1 test1-> test1.print();
            case Test2 test2-> test2.print();
            case Test4 test4-> test4.print();
            case Test3 test3-> test3.print();
            default -> throw new IllegalStateException("Unexpected value: " + sc);
        }
    }
}
