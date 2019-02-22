package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/22
 * @email maosongran@gmail.com
 */
public class Leetcode_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        operation(image, sr, sc, image[sr][sc], newColor);
        // this.image = image;
        return image;
    }

    private void operation(int[][] image, int sr, int sc, int oldColor, int newColor) {
        System.out.println(sr + " " + sc + " ");
        if (sr < 0 || sr >= image.length || sc <0 || sc >= image[0].length || image[sr][sc] != oldColor)
            return;
        image[sr][sc] = newColor;

        operation(image, sr+1, sc, oldColor, newColor);
        operation(image, sr-1, sc, oldColor, newColor);
        operation(image, sr, sc+1, oldColor, newColor);
        operation(image, sr, sc-1, oldColor, newColor);
    }
}
