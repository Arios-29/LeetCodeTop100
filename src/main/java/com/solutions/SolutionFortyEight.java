package com.solutions;

/**
 * @author ChenYu
 * @date 2021/9/23 16:26
 */
public class SolutionFortyEight {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int ri = 0;
        int rj = n - 1;
        while (ri < rj) {
            for (int col = 0; col < n; col++) {
                int tmp = matrix[ri][col];
                matrix[ri][col] = matrix[rj][col];
                matrix[rj][col] = tmp;
            }
            ri++;
            rj--;
        }
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }
}
