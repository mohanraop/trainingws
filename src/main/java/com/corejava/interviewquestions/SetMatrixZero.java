package com.corejava.interviewquestions;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement:
    Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and
     then return the matrix.

Examples:

Examples 1:

    Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

    Output: [[1,0,1],[0,0,0],[1,0,1]]

    Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.

    Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

    Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0


 */
public class SetMatrixZero {
    public static void main(String[] args) {
        int matrix[][]= {{1,1,1},{1,0,1},{1,1,1}};
        setZeros(matrix);
        int matrix1[][]= {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeros(matrix1);
    }

    public static void setZeros(int matrix[][]) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for(int row=0;row<matrix.length;row++){
            for (int column = 0; column<matrix[0].length;column++){
                if(matrix[row][column]==0){
                    rows.add(row);
                    columns.add(column);
                }
            }
        }
        for(Integer row : rows){
            for(int column=0;column<matrix[0].length;column++){
                matrix[row][column]=0;
            }
        }
        for(Integer column : columns){
            for(int row=0;row<matrix.length;row++){
                matrix[row][column]=0;
            }
        }
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


