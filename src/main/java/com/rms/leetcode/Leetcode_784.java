package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2019/02/22
 * @email maosongran@gmail.com
 */
public class Leetcode_784 {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        operation(S, 0);
        res.add(S);
        return res;
    }

    private void operation(String S, int i) {
        char[] c = S.toCharArray();
        for (; i < c.length; ++i) {
            if (Character.isLetter(c[i])) {
                char[] tmp = c;
                if (Character.isLowerCase(c[i])) {
                    tmp[i] = Character.toUpperCase(tmp[i]);
                } else {
                    tmp[i] = Character.toLowerCase(tmp[i]);
                }
                res.add(new String(tmp));
                operation(new String(tmp), i+1);
            }
        }
    }
}
