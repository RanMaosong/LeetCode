package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/10
 * @email maosongran@gmail.com
 */
public class Leetcode_345 {
    private boolean isVowels(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int i=0, j  = s.length()-1;
        while (i < j) {
            while (i < j && !isVowels(c[j])) {
                j--;
            }

            while (i < j && !isVowels(c[i])) {
                i++;
            }

            char cj = c[j];
            char ci = c[i];
            c[j] = ci;
            c[i] = cj;
            i++;
            j--;
        }

        return new String(c);
    }
}
