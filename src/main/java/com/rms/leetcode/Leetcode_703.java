package com.rms.leetcode;

import java.util.Arrays;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_703 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{5, -1});
        System.out.println("==========");
        kthLargest.add(2);   // returns 4
        kthLargest.add(1);   // returns 4
        kthLargest.add(-1);   // returns 5
        kthLargest.add(3);  // returns 5
        kthLargest.add(4);   // returns 8
    }
}

class KthLargest {
    int len = 0, k;
    int[] tree, nums;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        tree = new int[k];
        this.nums = nums;
        for (int i=0; i < k && i < nums.length; ++i) {
            insert(nums[i]);
        }
        System.out.println(Arrays.toString(tree));

        for (int i=k; i < nums.length; ++i) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (len < k) {
            insert(val);
        }else if (val > tree[0]) {
            tree[0] = val;
            int i=0;
            while (i < k/2) {
                int left = i*2 + 1, right = i * 2 + 2;
                if (right < k) {
                    int min = Math.min(tree[left], tree[right]);
                    if (tree[i] > min) {
                        int j = min == tree[left] ? left : right;
                        int tmp = tree[i];
                        tree[i] = tree[j];
                        tree[j] = tmp;
                        i = j;
                    } else {
                        break;
                    }

                } else if (tree[left] < val) {
                    int tmp = tree[i];
                    tree[i] = tree[left];
                    tree[left] = tmp;
                    i = left;
                } else {
                    break;
                }
//                System.out.println(i);
            }
        }
        System.out.println(Arrays.toString(tree));
        return tree[0];
    }

    private void insert(int num) {
        tree[len] = num;
        int cur = len++;
        int parent = (cur - 1) / 2;
        while (cur != 0 && tree[parent] >tree[cur]) {
            int tmp = tree[parent];
            tree[parent] = tree[cur];
            tree[cur] = tmp;
            cur = parent;
            parent = (cur - 1) / 2;
        }
    }

}
