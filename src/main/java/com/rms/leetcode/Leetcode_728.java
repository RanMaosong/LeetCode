package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2019/02/22
 * @email maosongran@gmail.com
 */
public class Leetcode_728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i=left; i <= right; ++i) {
            int num = i;
            while (num != 0) {
                int remain = num % 10;
                if (remain == 0)
                    break;
                if (i % remain != 0)
                    break;
                num /= 10;
            }

            if (num == 0)
                res.add(i);
        }

        return res;
    }
}
