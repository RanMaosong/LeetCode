package com.rms.leetcode;

/*
* 寻找字符串中最长回文字符串
 */
public class LongestPalindromicSubstring_005 {
    public  static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring_005().longestPalindrome6("abacdfgdcaba"));
        System.out.println(new LongestPalindromicSubstring_005().longestPalindrome6("cbbd"));
        new LongestPalindromicSubstring_005().longestPalindrome6("babad");
    }

    //  over time
    public String longestPalindrome(String s) {
        String reverseString = String.valueOf(new StringBuilder(s).reverse());
        String longestConmonString = new String();
        int length = s.length();
        for (int i=0;i<length-1;++i) {
            for (int j=length-1; j>i; --j) {
                String subString = s.substring(i, j+1);
                if (reverseString.contains(subString)) {
                    if (subString.length() > longestConmonString.length()) {
                        String reverseSubString = String.valueOf(new StringBuilder(subString).reverse());
                        if (reverseSubString.equals(subString)) {
                            longestConmonString = subString;
                        }
                    }
                }
            }
        }
        if (longestConmonString.length() > 0)
        {
            return longestConmonString;
        } else {
            return s.substring(0, 1);
        }

    }


    /*
    * 暴力枚举求解
    * 以当前字符为奇数回文字符串的中心字符，或为偶数回文字符串的中间两字符之一
    * 时间复杂度： O(n^2)
    * 空间复杂度: O(1)
     */
    public String longestPalindrome1(String s) {
        // 保存当前最长回文字符串的起始坐标
        int startIndex = 0;
        int endIndex = 0;

        // 寻找回文字符串时的起始坐标
        int left, right;
        int len = s.length();
        for (int i=0; i < len; ++i) {
            // 处理奇数回文字符串
            // s[i] 为中心字符串
            left = i;
            right = i;
            while(left>=0 && right<len) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                --left;
                ++right;
            }

            if ((right-left-1) > (endIndex-startIndex+1)) {
                startIndex = left + 1;
                endIndex = right-1;
                System.out.println(left + "," + right);
            }


            // 处理偶数回文字符串
            // s[i]维回文字符串的中间两个字符之一

            left = i;
            right = i+1;
            while(left>=0 && right<len) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }

                --left;
                ++right;
            }
            if ((right-left-1) > (endIndex-startIndex+1)) {
                startIndex = left + 1;
                endIndex = right-1;
            }

        }

        return s.substring(startIndex, endIndex+1);
    }
    /*
    * 动态规划
    * 时间复杂度： O(N^2)
    * 空间复杂度:O(n^2)
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        boolean[][] table = new boolean[len][len];
        int startIndex = 0, endIndex = 0;
        for (int j = 0; j < len; ++j) {
            table[j][j] = true;
            for (int i = 0; i < j ; ++i) {
                if (s.charAt(i) == s.charAt(j) && (j-i == 1 || table[i+1][j-1])) {
                    if (j-i+1 > endIndex-startIndex+1) {
                        startIndex = i;
                        endIndex = j;

                    }
                    table[i][j] = true;
                }
            }

        }


        return s.substring(startIndex, endIndex+1);
    }

    /*
    * Manacher Algorithm
    * 计算复杂度：O(n)
    * 空间复杂度: O(n)
     */
    public String longestPalindrome3(String s) {
        // 预处理字符串
        StringBuilder temp = new StringBuilder("#");
        for(int i = 0; i < s.length(); ++i) {
            temp.append(s.charAt(i));
            temp.append("#");
        }
        System.out.println(temp);
        String s1 = temp.toString();

        int len = s1.length();
        int[] p = new int[len];
        int maxCenter = 0;
        int center = 0, maxRight = 0;
        for (int i=0; i<len; ++i) {
            int syncIndex = 2 * center - i;
            p[i] = (i < maxRight) ? Math.min(p[syncIndex], maxRight-i):1;
            while (i-p[i]>=0 && i+p[i] < len && s1.charAt(i-p[i]) == s1.charAt(i+p[i])) {
                p[i]++;
            }

            if (p[i] >= p[maxCenter]) {
                maxCenter = i;
            }

            if ( i + p[i] > maxRight) {
                center = i;
                maxRight = center + p[i];
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i=maxCenter-p[maxCenter]+1; i<maxCenter+p[maxCenter]; ++i) {
            if (temp.charAt(i) != '#')
                result.append(temp.charAt(i));
        }
        return result.toString();
    }

    int len=0,maxLength=0,init=0;
    public String longestPalindrome4(String s) {
        char[] chars = s.toCharArray();
        len = s.length();
        if (len<2)
            return s;
        for (int i=0; i<len;++i) {
            i=manacher(chars, i);
        }
        return s.substring(init, init+maxLength);
    }

    public int manacher(char[] chars, int k) {
        int i=k-1, j=k;
        while(j<len-1 && chars[j]==chars[j+1])
            ++j;
        int nextCenter = j++;
        while(i>=0 && j<len && chars[i] == chars[j]) {
            --i;
            ++j;
        }
        if (j-i-11>maxLength) {
            maxLength=j-i-1;
            init = i+1;
        }
        return nextCenter;

    }
    public String longestPalindrome5(String s) {
        int startIndex=0, endIndex=0;
        int left, right;
        int len = s.length();
        if  (len<2)
            return s;
        for (int i=0; i<len; ++i) {
            left = i-1;
            right = i;
            while(right<len-1 && s.charAt(right+1) == s.charAt(right))
                ++right;
            ++right;
            while(left>=0 && right<len && s.charAt(left) == s.charAt(right)) {
                ++right;
                --left;
            }
            if (right-left -1 > endIndex-startIndex) {
                startIndex = left+1;
                endIndex = right;
            }
        }
        System.out.println(len + " " + startIndex + "" + endIndex);
        return s.substring(startIndex, endIndex);
    }

    public String longestPalindrome6(String s) {
        // 保存得到的最长回文子串的起始位置
        int left = 0, right = 0;
        int len = s.length();

        for (int i=0; i<len; ++i) {
            for (int j=i; j<len; ++j) {
                // 获取 s 的连续子串
                String subStr = s.substring(i, j+1);

                // 判断子串是否是回文字符串
                if (isPalindrome(subStr)) {
                    if (j-i > right-left) {
                        left = i;
                        right = j;
                    }
                }

            }
        }

        return s.substring(left, right+1);
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            ++left;
            --right;
        }

        return true;
    }

}
