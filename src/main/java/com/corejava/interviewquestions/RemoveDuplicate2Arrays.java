package com.corejava.interviewquestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicate2Arrays {
    public static void main(String[] args) {
        int i[] = {1, 2, 3, 4};
        int j[] = {5, 3, 2, 8};
        Set<Integer> finalList = new HashSet<>();
        Stream.of(i, j).forEach(c -> Arrays.stream(c).forEach(val -> finalList.add(val)));
        finalList.forEach(System.out::println);
        Set<Integer> afinalList = new HashSet<>();
        int il = i.length, jl = j.length, id = 0, jd = 0;

        while (id < il || jd < jl) {
            if (id < il)
                afinalList.add(i[id++]);
            if (jd < jl)
                afinalList.add(j[jd++]);
        }
        afinalList.forEach(System.out::println);

    }
}
