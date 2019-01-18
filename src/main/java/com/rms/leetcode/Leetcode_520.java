package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/18
 * @email maosongran@gmail.com
 */
public class Leetcode_520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return  true;

        String substr = word.substring(1, word.length());
        boolean flag1 = Character.isLowerCase(substr.charAt(0)), flag2;
        for (char c : substr.toCharArray()) {
            flag2 = Character.isLowerCase(c);
            if (flag1 != flag2)
                return false;
        }

        return Character.isLowerCase(word.charAt(0)) ? flag1 == true : true;
    }
}
