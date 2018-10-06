package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/06
 * @email maosongran@gmail.com
 */
public class LeetCode_168 {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n != 0) {
            int  tmp = (n-1) % 26;
            n = (n-1) / 26;
            result.append((char)('A' + tmp));

        }

        return result.reverse().toString();

    }

    public static void main(String[] args) {
        LeetCode_168 leetCode = new LeetCode_168();
//        System.out.println(leetCode.convertToTitle(1));
//        System.out.println(leetCode.convertToTitle(28));
        System.out.println(leetCode.convertToTitle(701));
    }

}
