package com.corejava.leetcode.medium;

public class MinWindow {
    public static void main(String[] args) {
       // String s = "ADOBECODEBANC", t = "ABC";
        String s = "bdab", t = "ab";
        System.out.println( minWindow(s, t));
    }
    public static String minWindow(String s, String t) {

        if(s.equals(t))
            return t;
        if(t.length()> s.length())
            return "";

        int startIndex=-1,length = Integer.MAX_VALUE;
        String temp = t,retStr="";

        for(int i=0;i<s.length();i++) {
            startIndex = -1;
            temp = t;
            for (int index = i; index < s.length(); index++) {
                String another = "" + s.charAt(index);
                if (temp.contains(another)) {
                    if (startIndex == -1) {
                        startIndex = index;
                    }
                    temp = temp.replace(another, "");
                    if (temp.isEmpty() && length > s.substring(startIndex, index).length()) {
                        retStr = s.substring(startIndex, index + 1);
                        length = retStr.length();
                        temp = t;
                        startIndex = -1;
                        if (length == t.length()) {
                            return retStr;
                        }
                    }
                }
            }
        }
        return retStr;
    }
}


/*
Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
