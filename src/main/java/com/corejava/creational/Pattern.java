package com.corejava.creational;

import java.io.Serializable;

class Pattern implements Cloneable, Serializable {

    static final Pattern pattern = new Pattern();

    private String name;

    private Pattern() {
    }

    public static Pattern getInstance() {
        return pattern;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Cloning is not supported");
    }

}
