package com.rms.leetcode;

import java.util.HashMap;

/**
 * @author Maosong Ran
 * @date 2018/12/28
 * @email maosongran@gmail.com
 */
public class Leetcode_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        else {
            int len = s.length();
            HashMap<Character, Integer> count1 = new HashMap<Character, Integer>();
            HashMap<Character, Integer> count2 = new HashMap<Character, Integer>();
            for (int i=0; i<len; ++i) {
                if (count1.containsKey(s.charAt(i)))
                {
                    count1.put(s.charAt(i), count1.get(s.charAt(i))+1);
                } else {
                    count1.put(s.charAt(i), 1);
                }

                if (count2.containsKey(t.charAt(i)))
                {
                    count2.put(t.charAt(i), count2.get(t.charAt(i))+1);
                } else {
                    count2.put(t.charAt(i), 1);
                }
            }

            return count1.equals(count2);
        }
    }

    public static  void main(String[] args) {
        Leetcode_242 lt = new Leetcode_242();
        System.out.println(lt.isAnagram("anagram", "nagaram"));
        System.out.println(lt.isAnagram("rat", "car"));
    }
}
