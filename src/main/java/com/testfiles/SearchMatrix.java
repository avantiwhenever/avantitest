package com.testfiles;

public class SearchMatrix {

    public static void main(String args[]) {
        int matrix[][];
    }

    private static int searchMatrix(int[][] matrix, int target) {
        if (matrix == null ||matrix.length == 0) {
            return -1;
        }
        return searchBinaryMatrix(matrix, target, 0, 0, matrix.length, matrix[0].length);
    }

    private static int searchBinaryMatrix(int[][] matrix, int target, int left,  int up, int right, int down) {
        if (left > right || down > right) {
            return -1;
        } else if (target < matrix[left][right]) {
            return -1;
        }
        return -1;
    }
}
