package com.interview.string;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.regex.Pattern.compile;

public class StringCounting {

    public static void main(String[] args) {

        String block = """
                hello i am mohan.
                i am working as an architect . 
                looking for an opportunity .
                it was a abcdefghijklmnopqrstuv .
                """;

       IntSummaryStatistics iss =  Pattern.compile(" ")
                .splitAsStream(block)
               .collect(Collectors.summarizingInt(String::length));
        System.out.println(iss.getCount());
        System.out.println(iss);


    }
}
