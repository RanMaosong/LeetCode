package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/22
 * @email maosongran@gmail.com
 */
public class Leetcode_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        for (char c : letters) {
            if (c > target)
                return c;
        }

        return letters[0];
    }
    public char nextGreatestLetter1(char[] letters, char target) {
        int i = 0, j = letters.length-1;
        if (target >= letters[j] || target < letters[0])
            return letters[0];
        while (i < j) {
            int mid = (i + j) / 2;
            if (letters[mid] > target) {
                j = mid;
            } else {
                i = mid;
            }
        }

        return letters[j];
    }
}
