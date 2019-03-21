package com.rms.leetcode;

import sun.net.www.HeaderParser;

import java.util.Arrays;

public class Leetcode_215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        return nums[n-k];
    }

    public int findKthLargest1(int[] nums, int k) {
        int[] heap = new int[k];
        int n = 0;
        for (int num : nums) {
            if (n < k) {
                heap[n++] = num;
                shiftup(heap, n-1);
            } else if (num > heap[0]) {
                heap[0] = num;
                shiftDown(heap);
            }

        }

        return heap[0];
    }

    public void shiftup(int[] heap, int i) {
        System.out.print(Arrays.toString(heap));

        while (i > 0) {
            int j = (i-1) / 2;
            if (heap[j] > heap[i]) {
                int tmp = heap[i];
                heap[i] = heap[j];
                heap[j] = tmp;
            } else {
                break;
            }
            i = j;
        }
        System.out.println(Arrays.toString(heap));

    }

    public void shiftDown(int[] heap) {
        System.out.print("ShiftDown" + Arrays.toString(heap));
        int i = 0, n = heap.length;
        while (2*i +1 < n || 2*i + 2 < n) {
            int left = 2*i+1, right = 2*i+2;
            if (left < n && right < n) {
                int min = Math.min(heap[left], heap[right]);
                if (heap[i] > min) {
                    if (heap[left] == min) {
                        int tmp = heap[i];
                        heap[i] = heap[left];
                        heap[left] = tmp;
                        i = left;
                    } else if (heap[right] == min) {
                        int tmp = heap[i];
                        heap[i] = heap[right];
                        heap[right] = tmp;
                        i = right;
                    }
                } else {
                    break;
                }

            } else if (left < n) {
                if (heap[left] < heap[i]) {
                    int tmp = heap[i];
                    heap[i] = heap[left];
                    heap[left] = tmp;
                    i = left;
                } else {
                    break;
                }
            } else {
                if (heap[right] < heap[i]) {
                    int tmp = heap[i];
                    heap[i] = heap[right];
                    heap[right] = tmp;
                    i = right;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(heap));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
//        for (int i=0; i < nums.length; ++i)
//            nums[i] = i;
        new Leetcode_215().findKthLargest1(nums, 20);

    }
}
