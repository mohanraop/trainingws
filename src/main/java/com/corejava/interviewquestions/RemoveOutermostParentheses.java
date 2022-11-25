package com.corejava.interviewquestions;

import java.util.Stack;

//Leetocode 1021
public class RemoveOutermostParentheses {


    public String removeParenthesesStack(String input){
        StringBuilder result = new StringBuilder();
        Stack<Character> parentheses = new Stack<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='('){
                if(parentheses.size()>1){
                    result.append(""+input.charAt(i));
                }
                parentheses.push(input.charAt(i));
            }else{
                if(parentheses.size()>1)
                result.append(""+input.charAt(i));
                parentheses.pop();
            }
        }
        return result.toString();
    }


    public String removeParentheses(String input){
        StringBuilder result = new StringBuilder();
        int operator=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='('){
                if(operator>1){
                    result.append(""+input.charAt(i));
                }
                operator++;
            }else{
                if(operator>1) {
                    result.append("" + input.charAt(i));
                }
               operator--;
            }
        }
        return result.toString();
    }
}
