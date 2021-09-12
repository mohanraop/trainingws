package com.corejava.basic;

public enum EnumMain {
    one("one"),two("two"),three("three");
    String name;
    EnumMain(String name){
        this.name=name;
    }
    public String getName(){return this.name;}

    public static void main(String[] args) {
        for (EnumMain e:EnumMain.values()){
            System.out.println(e.getName());
        }
    }
}
