package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */
public class Leetcode_427 {
    public Node construct(int[][] grid) {
        return operation(grid, 0, grid[0].length, 0, grid.length);
    }

    private Node operation(int[][] grid, int left, int right, int top, int bottom) {
        int val = grid[top][left];
        for(int i=top; i < bottom; ++i) {
            for (int j=left; j < right; ++j) {
                if (grid[i][j] != val) {
                    Node topLeft = operation(grid, left, (left + right)/2, top, (top + bottom)/2);
                    Node bottomLeft = operation(grid, left,(left+right)/2, (top + bottom)/2, bottom);
                    Node topRIght = operation(grid, (left+right)/2, right, top, (top + bottom)/2);
                    Node bottomRIght = operation(grid,(left+right)/2, right, (top+bottom)/2, bottom);
                    return new Node(false, false, topLeft, topRIght, bottomLeft, bottomRIght);
                }
            }
        }
        Node result = new Node();
        result.val= val == 1?true : false;
        result.isLeaf = true;

        return result;
    }
}
