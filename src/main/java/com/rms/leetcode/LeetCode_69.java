package com.rms.leetcode;

public class LeetCode_69 {

    public int mySqrt(int x) {
//        if (x <= 1)
//            return x;
//        int i;
//        System.out.println("i = " + (x/2));
//        for (i = x/2; i >= 0; --i) {
//            if (Math.pow(i, 2) <= x && Math.pow(i+1, 2) > x)
//                break;
//        }
//
//        return i;

        // 二分法
        if (x <= 1)
            return x;
        int start = 0, end = x;
//        while ((end - start) != 1 && start != end) {
//            if (Math.pow(mid, 2) < x) {
//                start = mid;
//                mid = (end + start) /2;
//            } else if (Math.pow(mid, 2) == x) {
//                return mid;
//            } else {
//                end = mid;
//                mid = (end + start) /2;
//            }
//        }
//        return start;
        while (start != end) {
            int mid = (end + start) / 2;
            if (mid <= x/mid)
                start = mid + 1;
            else
                end = mid;
        }

        return start - 1;
    }

    public static void main(String[] args) {
        LeetCode_69 leetCode = new LeetCode_69();
//        System.out.println(leetCode.mySqrt(4));
        System.out.println(leetCode.mySqrt(8));
        System.out.println(leetCode.mySqrt(2147395599));
    }
}
