package com.corejava.ds;

/*input
GoodMorning Morning Morning.
Today I have have a party.
I and my friend sam sam is going to to dance.
Are you you coming??

Output

GoodMorning Morning.
Today I have a party.
I and my friend sam is going to dance.
Are you coming?.
*/



import java.util.*;
import java.util.regex.*;

public class PatternString {
    static String DOT = ".";
    static String QMARK = "?";
    static Pattern pt = Pattern.compile("\\b");

    static String SPACE = " ";
    static void addToList(String line,List<String> lines) {
        String arr[] = pt.split(line);
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> map = new HashMap<>();
        for(String val: arr){
            if(!SPACE.equals(val) && !map.containsKey(val)){
                sb.append(val).append(SPACE);
                map.put(val, 0);
            }
        }
        lines.add(sb.toString());
    }

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        addToList(line,lines);
        line = in.nextLine();
        addToList(line,lines);
        line = in.nextLine();
        addToList(line,lines);
        line = in.nextLine();
        addToList(line,lines);
        lines.forEach(System.out::println);
    }
}

