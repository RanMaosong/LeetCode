package com.rms.leetcode;

import java.util.Arrays;

public class Leetcode_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            int t = i, r = n-1-i, b = n - 1 - i, l =i;
//            System.out.println(i + " " + r + " " + b + " " + l);
            for (int j=0; j<(r-l); ++j) {
                int tmp = matrix[t+j][r];
                matrix[t+j][r] = matrix[t][l+j];

                int tmp2 = matrix[b][r-j];
                matrix[b][r-j] = tmp;



                tmp = matrix[b-j][l];
                matrix[b-j][l] = tmp2;

                matrix[t][l+j] = tmp;

//                for (int[] row : matrix) {
//                    System.out.println(Arrays.toString(row));
//                }
//                System.out.println("===========================");

            }
        }

    }

    public static void main(String[] args) {
        new Leetcode_48().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
