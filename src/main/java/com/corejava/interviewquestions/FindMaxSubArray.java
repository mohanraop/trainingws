package com.corejava.interviewquestions;

public class FindMaxSubArray {
    public static int  maxSubArra(int array[][]){
        int i=0;
        if(array.length==0)
            return i;
        int cArray [][] = new int [array.length+1][array.length+1];
        for(int oIndex=1;oIndex<=array.length;oIndex++){
            for (int iIndex=1;iIndex<=array.length;iIndex++){
                if(array[oIndex-1][iIndex-1]==1){
                    cArray[oIndex][iIndex]=Math.max(cArray[oIndex-1][iIndex],cArray[oIndex][iIndex-1])+1;
                }else{
                    cArray[oIndex][iIndex]=cArray[oIndex][iIndex-1];
                }
            }
        }
        return cArray[array.length][array.length];
    }

    public static void main(String[] args) {
        int array[][] = {{0, 1, 1, 0},
                        {1, 1 ,1, 1},
                        {1 ,1, 1, 1},
                        {1, 1 ,0, 0}};
        System.out.printf("maxSubArra = "+maxSubArra(array));
    }
}
