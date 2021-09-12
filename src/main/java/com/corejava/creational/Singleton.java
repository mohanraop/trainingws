package com.corejava.creational;

import java.io.Serializable;

public class Singleton {
    public static void main(String[] args) {
        Pattern p = Pattern.getInstance();
        p.setName("Singleton pattern");
        System.out.println(p.getName());
    }
}

