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

    public void printQr(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == 1){
                    System.out.print("██");
                }
                else if(matrix[i][j] == 0){
                    System.out.print(" ");
                }
                else{
                    System.out.print("#.");
                }
            }
            System.out.println();
        }
    }

    // add separator
    private void addSeparator(int startRow, int startCol, int[][] matrix){
        for(int i = -1; i <= 7; i++){
            for(int j = -1; j <= 7; j++){
                int r = startRow + i;
                int c = startCol + j;

                if(r >= 0 && r < matrix.length && c >= 0 && c < matrix.length && matrix[r][c] == -1){
                    matrix[r][c] = 0;
                }
            }
        }
    }

    // all Alignment
    private void addAlignment(int centreRow, int centreCol, int[][] matrix){
        for(int i = -2; i <= 2; i++){
            for(int j = -2; j <= 2; j++){

                int r = centreRow + i;
                int c = centreCol + j;

                // skip if border
                if(r < 0 || r >= matrix.length || c < 0 || c >= matrix.length) continue;
                // do not override the exist pattern
                if(matrix[r][c] != -1) continue;
                // outer border
                if(i == -2 || i == 2 || j == -2 || j == 2) matrix[r][c] = 1;
                // center
                else if(i == 0 && j == 0) matrix[r][c] = 1;
                // inner
                else matrix[r][c] = 0;
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
        addSeparator(0, 0, matrix);
        addAlignment(26, 26, matrix);

        placefinder(0, size - 7, matrix);
        addSeparator(0, size - 7, matrix);
        addAlignment(26, 26, matrix);

        placefinder(size - 7, 0, matrix);
        addSeparator(size - 7, 0, matrix);
        addAlignment(26, 26, matrix);
        return matrix;
    }

    public static void main(String args[]){
        QrMatrixBuilder qrMatrixBuilder = new QrMatrixBuilder();
        int[][] m = qrMatrixBuilder.buildMatrix();
        qrMatrixBuilder.printQr(m);
    }
}
