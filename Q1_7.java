/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author rominparekh
 */
public class Q1_7 {

    private int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 0, 15}, {16, 17, 18, 19, 20}};

    protected void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // Store the row and column index with o value
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        // Nullify columns
        for (int i = 0; i < column.length; i++) {
            if (column[i]) {
                nullifyColumn(matrix, i);
            }
        }
    }

    protected void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    protected void nullifyColumn(int[][] matrix, int column) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][column] = 0;
        }
    }

    protected void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
        }
        System.out.println();
    }

    protected void start() {
        System.out.println("Before");
        print(this.matrix);
        setZeros(this.matrix);
        System.out.println("\nAfter");
        print(this.matrix);
    }
}
