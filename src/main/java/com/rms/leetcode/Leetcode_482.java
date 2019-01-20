package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/17
 * @email maosongran@gmail.com
 */
public class Leetcode_482 {
    public String licenseKeyFormatting(String S, int K) {
        if (S.length() == 1)
            return S;
        StringBuilder res = new StringBuilder();
        char[] c = S.toCharArray();
        int len = c.length;
        char[] tmp = new char[K];
        int j=0;
        for (int i=len-1; i >= 0; --i) {
            if (c[i] != '-') {
                tmp[j++] = Character.toUpperCase(c[i]);
            }
            if (j == K) {
                res.append(tmp);
                res.append("-");
                j = 0;
            }
        }

        res = res.reverse();
        len = res.length();
        String str= res.toString();
        if (res.substring(0, 1) == "-")
            str = res.substring(1, len);

        return str;
    }
}
