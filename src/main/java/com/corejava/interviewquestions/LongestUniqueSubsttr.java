package com.corejava.interviewquestions;
public class LongestUniqueSubsttr{

    public static int findlongest(String str){
        String empty="";
        if(str==null || str.equals(empty))
            return 0;

        int maxLength=0,index=0;

        StringBuilder sb=  new StringBuilder(empty);
        for(char ch : str.toCharArray()){
            index= sb.indexOf(String.valueOf(ch));
            if(sb.indexOf(String.valueOf(ch))>=0){
                maxLength = Math.max(sb.length(),maxLength);
                sb=  new StringBuilder(sb.substring(index+1));
                //System.out.println(sb);
            }
            sb.append(ch);
        }
        maxLength = Math.max(sb.length(),maxLength);

        return maxLength;
    }

    public static void  main(String[] args) {
        //String str = "geeksforgeeks";
        //String str = "ABDEFGABEF";
        //String str = "abcabcbb";
        //String str = "bbbbb";
        //String str = "pwwkew";
        String str = "dvdf";
        //String str = "";
        //String str = null;
        //String str = " ";


        System.out.println("The input string is " + str);

        int len = findlongest(str);
        System.out.println("The length of the longest "
                + "non-repeating character "
                + "substring is " + len);
    }
}