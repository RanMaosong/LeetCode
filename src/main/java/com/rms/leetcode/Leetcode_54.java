package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_54 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return res;
        int m = matrix.length, n = matrix[0].length;
        operation(matrix,0, n-1, m-1, 0);

        return res;
    }

    private void operation(int[][] matrix, int t, int r, int b, int l) {
        System.out.println(t + " " + r + " " + b + " " + l);
        if (t > b || l > r)
            return;
        if (t == b) {
            while (l <= r)
                res.add(matrix[t][l++]);
        } else if ( l == r) {
            while (t <= b)
                res.add((matrix[t++][l]));
        } else {
            int m = matrix.length, n = matrix[0].length;
            for (int i=l; i < r; ++i)
                res.add(matrix[t][i]);
            for (int i=t; i < b; ++i)
                res.add(matrix[i][r]);
            for (int i=r; i > l && b > t; --i)
                res.add(matrix[b][i]);
            for (int i=b; i > t && l < r; --i)
                res.add(matrix[i][l]);
            operation(matrix, t+1, r-1, b-1, l+1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_54().spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}}));
    }
}
