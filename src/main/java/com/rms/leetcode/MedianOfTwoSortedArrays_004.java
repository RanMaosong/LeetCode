package com.rms.leetcode;


/*There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5*/

public class MedianOfTwoSortedArrays_004 {
    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4, 5}));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            int len = nums2.length;
            return (nums2[len/2] + nums2[len/2 - Math.abs(len%2 -1)]) / 2.0;
        } else if (nums2.length == 0) {
            int len = nums1.length;
            return (nums1[len/2] + nums1[len/2 - Math.abs(len%2-1)]) / 2.0;
        } else if(nums1.length == 1 && nums2.length == 1) {
            return (nums1[0] + nums2[0]) / 2.0;
        } else {
            int total = nums1.length + nums2.length;
            int l_a = 0, r_a = nums1.length - 1;
            int l_b = 0, r_b = nums2.length - 1;
            int m_a, m_b;
            if (nums1.length <= nums2.length){
                m_a = (l_a + r_a) / 2;
                m_b = (total + 1) / 2  - m_a - 2;
            } else {
                m_b = (l_b + r_b) / 2;
                m_a = (total + 1) / 2 - m_b - 2;
            }

            int len_a = nums1.length, len_b = nums2.length;
            System.out.println(m_a + "  " + m_b);
            int index = 1;
            while (true) {
                System.out.println("======" + index + "=====");
                System.out.println(l_a + "<->" + m_a + "<->" + r_a);
                System.out.println(l_b + "<->" + m_b + "<->" + r_b);
                index++;
                if (index > 10)
                    break;
                if (l_a > m_a)
                    break;
                if (l_b > m_b)
                    break;
                if (m_a < len_a-1 && m_b < len_b - 1) {
                    if (nums1[m_a] <= nums2[m_b+1] && nums2[m_b] <= nums1[m_a+1]) {
                        break;
                    } else if (nums1[m_a] > nums2[m_b+1]) {
                        int num1 = (m_a - l_a + 1) / 2;
                        int num2 = (r_b - m_b + 1) / 2;
                        int num = num1 < num2 ? num1 : num2;
                        num = num == 0? 1 : num;

                        r_a = m_a;
                        m_a -= num;
                        l_b = m_b;
                        m_b += num;
                    } else {
                        int num1 = (r_a - m_a + 1) / 2;
                        int num2 = (m_b - l_b + 1) / 2;
                        int num = num1 < num2 ? num1 : num2;
                        num = num == 0? 1 : num;
                        System.out.println(num);
                        l_a = m_a;
                        m_a += num;
                        r_b = m_b;
                        m_b -= num;
                    }
                } else if (m_a < len_a - 1) {
                    if (nums2[m_b] <= nums1[m_a+1]) {
                        break;
                    } else {
                        int num1 = (r_a - m_a + 1) / 2;
                        int num2 = (m_b - l_b + 1) / 2;
                        int num = num1 < num2 ? num1 : num2;
                        num = num == 0? 1 : num;

                        l_a = m_a;
                        m_a += num;
                        r_b = m_b;
                        m_b -= num;
                    }
                } else {
                    if (nums1[m_a] < nums2[m_b + 1]) {
                        break;
                    } else {
                        int num1 = (m_a - l_a + 1) / 2;
                        int num2 = (r_b - m_b + 1) / 2;
                        int num = num1 < num2 ? num1:num2;
                        num = num == 0? 1 : num;

                        l_b = m_b;
                        m_b += num;
                        r_a = m_a;
                        m_a -= num;
                    }
                }

            }

            int left = m_a + m_b + 2;
            int right = total - left;
            System.out.println(left - right);
            int left_max, right_min;
            if (left - right == 0) {
                if (m_a == -1) {
                    if (m_b == len_b -1) {
                        return (nums1[0] + nums2[m_b]) / 2.0;
                    } else {
                        right_min = Math.min(nums1[0], nums2[m_b+1]);
                        left_max = nums2[m_b];
                        return (left_max + right_min) / 2.0;
                    }
                } else if (m_b == -1) {
                    if (m_a == len_a - 1) {
                        return (nums2[0] + nums1[m_a]) / 2.0;
                    } else {
                        right_min = Math.min(nums2[0], nums1[m_a+1]);
                        left_max = nums1[m_a];

                        return (left_max + right_min) / 2.0;
                    }
                } else if (m_a == len_a-1 && m_b != -1) {
                    left_max = Math.max(nums1[m_a], nums2[m_b]);
                    right_min = nums2[m_b + 1];
                    return (left_max + right_min) / 2.0;
                } else if (m_b == len_b-1 && m_a != -1) {
                    left_max = Math.max(nums1[m_a], nums2[m_b]);
                    right_min = nums1[m_a +1];
                    return (left_max + right_min) / 2.0;
                } else {
                    left_max = Math.max(nums1[m_a], nums2[m_b]);
                    right_min = Math.min(nums1[m_a+1], nums2[m_b+1]);

                    return (left_max + right_min) / 2.0;
                }
            }  else {
                if (m_a == -1) {
                    return nums2[m_b];
                } else if (m_b == -1) {
                    return nums1[m_a];
                } else {
                    return Math.max(nums1[m_a], nums2[m_b]);
                }
            }
        }


    }

}