package com.rms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_55 {
    public boolean canJump(int[] nums) {
        return operation(nums, 0);
    }

    private boolean operation(int[] nums, int cur) {
//        System.out.println(cur);
        if (cur >= nums.length)
            return false;
        else if (cur == nums.length-1)
            return true;
        else {
            int num = nums[cur];
            for (int i=1; i <= num; ++i) {
                if (operation(nums, cur + i))
                    return true;
            }
            return false;
        }
    }
    public boolean canJump1(int[] nums) {
        Set<Integer> pos = new HashSet<>();
        pos.add(0);
        int n = nums.length;
        for (int i=0; i < n; ++i) {
            if (pos.contains(i)) {
                for (int j=1; j <= nums[i]; ++j) {
                    if (i + j == n-1) {
                        return true;
                    } else if (i+j > n-1) {
                        break;
                    }
                    pos.add(i + j);
                }
            }
        }

        return pos.contains(n-1);
    }

    public boolean canJump2(int[] nums) {
        int i = nums.length-2, cur = nums.length-1;
        while (i >=0 ) {
            if (i + nums[i] >= cur)
                cur = i;
            --i;
        }

        return  cur == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_55().canJump1(new int[]{2,3,1,1,4}));
    }
}
