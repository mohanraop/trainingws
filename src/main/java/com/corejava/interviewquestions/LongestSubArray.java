package com.corejava.interviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArray {
    public static void main(String[] args) {
        int A[] = {1, 2, 8, 2, 1}, B[] = {8, 2, 1, 4, 7};//821---3
        //1-0 ,1-2;--max 1
        //2-1,p


        System.out.println(lengthLongestSubArray(A,B));
        System.out.println("DP="+lengthLongestSubArrayDP(A,B));
        int c[]={0,0,0},d[]={0,0,0};
        System.out.println(lengthLongestSubArray(c,d));
        int e[]={1,2,3},f[]={4,5,6};
        System.out.println(lengthLongestSubArray(e,f));

        int g[]={0,0,0,0,0,0,1,0,0,0},h[]={0,0,0,0,0,0,0,1,0,0};//expected 9 ,actual 6
        System.out.println(lengthLongestSubArray(g,h));
        System.out.println(lengthLongestSubArray2(g,h));
        System.out.println(lengthLongestSubArray2(g,h));
    }
    public static int lengthLongestSubArray2(int A[],int B[]){
        int ans = 0;
        Map<Integer, ArrayList<Integer>> Bstarts = new HashMap();
        for (int j = 0; j < B.length; j++) {
            Bstarts.computeIfAbsent(B[j], x -> new ArrayList()).add(j);
        }

        for (int i = 0; i < A.length; i++)
            if (Bstarts.containsKey(A[i])) {
            for (int j: Bstarts.get(A[i])) {
                int k = 0;
                while (i+k < A.length && j+k < B.length && A[i+k] == B[j+k]) {
                    k++;
                }
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }

   // int A[] = {1, 2, 8, 2, 1}, B[] = {8, 2, 1, 4, 7};//821---3
    public static int lengthLongestSubArrayDP(int A[],int B[]) {
      int dp[][]= new int[A.length+1][B.length+1];
      int ans = 0;
      for(int i = 1;i<=A.length;i++){
          for(int j =1;j<=B.length;j++){
              if(A[i-1]==B[j-1]){
                  dp[i][j]=dp[i-1][j-1]+1;
                 ans = Math.max(ans,dp[i][j]);
              }else{
                  dp[i][j]=0;
              }
          }
      }
        return ans;
    }
    public static int lengthLongestSubArray(int a[],int b[]){
        int maxLength = 0 ;
        if(a.length == 0 || b.length == 0){
            return maxLength;
        }

        int tempCount = 0,prevIndex =0 ;
            for (int i = 0; i < a.length; i++) {
                for (int j = prevIndex; j < b.length; j++) {
                    if (a[i] == b[j]) {
                        prevIndex = j + 1;
                        tempCount++;
                        if (maxLength < tempCount) {
                            maxLength = tempCount;
                        }
                        break;
                    } else {
                        prevIndex = 0;
                        tempCount = 0;
                    }
            }
        }
        return maxLength;
    }
}
