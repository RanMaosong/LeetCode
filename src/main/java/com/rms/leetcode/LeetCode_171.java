package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/07
 * @email maosongran@gmail.com
 */
public class LeetCode_171 {
    public int titleToNumber(String s) {
        int len = s.length();
        int result = 0;
        for (int i=len-1; i >= 0; --i) {
            int tmp = s.charAt(i) - 'A' + 1;
            if (result == 0) {
                result = tmp;
            } else {
                result += tmp * Math.pow(26, len -1-i);
            }
        }

        return result;
    }
    public int titleToNumber2(String s) {
        int res = 0, len = s.length();
        for(int i=0; i < len; ++i) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        LeetCode_171 leetCode = new LeetCode_171();
        System.out.println(leetCode.titleToNumber("A"));
        System.out.println(leetCode.titleToNumber("AB"));
        System.out.println(leetCode.titleToNumber("ZY"));
        System.out.println(leetCode.titleToNumber("AAA"));
    }
}
