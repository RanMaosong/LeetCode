package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/11
 * @email maosongran@gmail.com
 */
public class Leetcode_405 {
    public String toHex(int num) {
        if (num == 0)
            return "0";
        char[] map={'0', '1', '2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0xf]);
            num = num >>> 4;
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-1>>>4));
        int a = -1 >>> 4;
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
    }
}
