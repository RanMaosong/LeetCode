package com.rms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */
public class Leetcode_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length())
            return result;
        int len1 = s.length(), len2 = p.length();
        char[] ps = p.toCharArray();
        Arrays.sort(ps);
        String sortedP = String.valueOf(ps);

        for (int i=0; i <= len1 - len2; ++i) {
            char[] ss = s.substring(i, i+len2).toCharArray();
            Arrays.sort(ss);
            String sortedS = String.valueOf(ps);
            if (sortedS.equals(sortedP))
                result.add(i);
        }

        return result;

    }
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return result;

        int[] hash = new int[256];

        for (char i : p.toCharArray()) {
            hash[i]++;
        }
        int left = 0, right = 0, count = p.length(); // 差异度

        while (right < s.length()) {
            if (hash[s.charAt(right)] > 0) {
                --count;
            }
            hash[s.charAt(right)]--;
            right++;

            if (count == 0)
                result.add(left);

            if (right - left == p.length()) {
                if (hash[s.charAt(left)] >= 0)
                    ++count;
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_438().findAnagrams1("adbc", "abc"));
    }
}
