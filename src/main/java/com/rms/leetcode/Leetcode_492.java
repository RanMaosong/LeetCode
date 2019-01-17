package com.rms.leetcode;

public class Leetcode_492 {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area), l=0;
        while (w > 0) {
            if (area % w == 0) {
                l = area / w;
                break;
            } else {
                --w;
            }
        }

        return new int[]{l, w};
    }
}
