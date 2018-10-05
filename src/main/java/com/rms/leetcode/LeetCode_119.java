package com.rms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2018/10/05
 * @email maosongran@gmail.com
 */
public class LeetCode_119 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (rowIndex == 0){
            result.add(1);
            return result;
        }

        for(int i=1; i <= rowIndex; ++i) {
            ArrayList<Integer> nextLine = new ArrayList<Integer>(i+1);
            nextLine.add(1);
            for(int j=1; j < result.size(); ++j) {
                nextLine.add(result.get(j-1) + result.get(j));
            }

            nextLine.add(1);
            result = nextLine;
        }

        return result;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex == 1) {
            result.add(1);
            return result;
        }
        for (int i=0; i <= rowIndex; ++i) {
            result.add(zuhe(rowIndex, i));
        }
        return result;

    }

    private int zuhe(int n, int m) {
        int a = 1, b = 1;
        for (int i = 1; i <= m; ++i) {
            a *= i;
            b *= (n - i + 1);
            if (b % a == 0) {
                b /= a;
                a = 1;
            }

        }
        return (int)(b / a);
    }

    public List<Integer> getRow3(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (rowIndex == 0){
            result.add(1);
            return result;
        }
        result.add(1);
        for(int i=1; i <= rowIndex; ++i) {
            result.add(1);
            for (int j =i-1; j > 0; --j) {
                result.set(j, result.get(j) + result.get(j-1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode_119 leetCode = new LeetCode_119();
        System.out.println(leetCode.getRow(3));
        System.out.println(leetCode.getRow2(5));
        System.out.println(leetCode.getRow3(5));
//        System.out.println(leetCode.zuhe(13, 11));
    }
}
