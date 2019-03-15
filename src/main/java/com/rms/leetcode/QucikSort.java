package com.rms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QucikSort {
    private void quickSort(Integer[] arr, int i, int j) {
        if (i >= j)
            return;
        else {
            int l = i, r = j;
            int num = arr[l++];
            int cur = i;
            while (l <= r) {
                if (arr[l] < num) {
                    arr[cur++] = arr[l++];

                } else {
                    int tmp = arr[r];
                    arr[r--] = arr[l];
                    arr[l] = tmp;
                }

                arr[cur] = num;
            }

            quickSort(arr, i, cur-1);
            quickSort(arr, cur+1, j);

        }

    }

    public static void main(String[] args) {
        int n = 30;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i < n; ++i)
            list.add(i);

        Collections.shuffle(list);
        System.out.println(list);
        Integer[] arr = new Integer[n];
        list.toArray(arr);
        new QucikSort().quickSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
}
