package com.rms.leetcode;

public class LeetCode_67 {
    public String addBinary(String a, String b) {
        int aLen = a.length(), bLen = b.length();
        int i = aLen-1, j = bLen-1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i) - '0';
            if (j >= 0)
                sum += b.charAt(j) - '0';
            result.append(sum % 2);
            carry = sum / 2;

            --i;
            --j;
        }

        if (carry != 0)
            result.append(carry);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode_67 leetCode = new LeetCode_67();
        System.out.println(leetCode.addBinary("11", "1"));
        System.out.println(leetCode.addBinary("1010", "1011"));
    }
}
