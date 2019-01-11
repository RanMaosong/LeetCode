package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/11
 * @email maosongran@gmail.com
 */
public class Leetcode_415 {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length()-1, len2 = num2.length()-1;

        int i=0;
        StringBuilder result = new StringBuilder();
        int jinwei = 0;
        while ((len1 - i) >= 0 || (len2 - i) >= 0) {
            int tmp = 0;
            if ((len1 - i) >= 0)
                tmp += num1.charAt(len1-i) -'0';
            if ((len2 - i) >= 0)
                tmp += num2.charAt(len2-i) -'0';
            tmp += jinwei;
            result.append(tmp % 10);
            jinwei = tmp / 10;
            ++i;
        }
        if (jinwei != 0)
            result.append(jinwei);
        return result.reverse().toString();
    }
}
