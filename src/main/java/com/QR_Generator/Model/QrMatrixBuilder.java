package com.QR_Generator.Model;

import java.util.Arrays;

public class QrMatrixBuilder {

    public void placefinder(int row, int col, int[][] matrix){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                int r = row + i;
                int c = col + j;

                if(i == 0 || i == 6 || j == 0 || j == 6){
                    matrix[r][c] = 1;
                }
                else if(i >= 2 && i <= 4 && j >= 2 && j <= 4){
                    matrix[r][c] = 1;
                }
                else{
                    matrix[r][c] = 0;
                }
            }
        }
    }
    public int[][] buildMatrix(){
        int size = 33;
        int[][] matrix = new int[size][size];

        for(int i = 0; i < size; i++){
            Arrays.fill(matrix[i], -1);
        }
        placefinder(0, 0, matrix);
        placefinder(0, size - 7, matrix);
        placefinder(size - 7, 0, matrix);

        return matrix;
    }

    public void printQr(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == 1){
                    System.out.println("██");
                }
                else if(matrix[i][j] == 0){
                    System.out.println(" ");
                }
                else{
                    System.out.println("..");
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        QrMatrixBuilder qrMatrixBuilder = new QrMatrixBuilder();
        int[][] m = qrMatrixBuilder.buildMatrix();
        qrMatrixBuilder.printQr(m);
    }
}
