package com.rms.leetcode;

public class _009_PalindromeNumber {
    public static void main(String[] args) {
        _009_PalindromeNumber solution = new _009_PalindromeNumber();
        System.out.println(solution.isPalindrome2(0));
    }
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        else if (0 <= x && x < 10)
            return true;
        else {
            char[] chars = String.valueOf(x).toCharArray();
            int i=0, j = chars.length - 1;
            while (i <= j) {
                if (chars[i] == chars[j]) {
                    ++i;
                    --j;
                } else {
                    return false;
                }
            }

            return true;
        }

    }

    public boolean isPalindrome2(int x) {
        if (x < 0 )
            return false;
        else if (0 <= x && x < 10)
            return true;
        else {
            int result = 0;
            int temp = x;

            while (temp != 0) {
                result = result * 10 + temp % 10;
                temp /= 10;
            }
            System.out.println(result);
            if (result == x)
                return true;
            else
                return false;

        }

    }

    public boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 ==0 && x != 0))
            return false;
        else if (0 <= x && x < 10)
            return true;
        else {
            int revertedNum = 0;
            while (x > revertedNum) {
                revertedNum = revertedNum * 10 + x % 10;
                x /= 10;
            }

            return x == revertedNum || x == revertedNum/10;
        }
    }
}

