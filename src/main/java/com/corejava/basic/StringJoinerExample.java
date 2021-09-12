package com.corejava.basic;

import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        StringJoiner st = new StringJoiner(",");
        st.add("1");
        st.add("2");
        st.add("3");
        st.add("4");
        st.add("5");
        System.out.println(st);

    }
}
