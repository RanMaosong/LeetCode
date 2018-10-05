package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2018/10/05
 * @email maosongran@gmail.com
 */
public class LeetCode_118 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return result;
        ArrayList<Integer> row = new ArrayList<Integer>(1);
        row.add(1);
        result.add(row);

        for(int i = 1; i < numRows; ++i) {
            List<Integer> line = result.get(i-1);

            List<Integer> newLine = new ArrayList<Integer>(i+1);
            newLine.add(1);

            for(int j=1; j < line.size(); ++j) {
                newLine.add(line.get(j-1) + line.get(j));
            }
            newLine.add(1);
            result.add(newLine);
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode_118 leetCode = new LeetCode_118();
        System.out.println(leetCode.generate(5));
    }
}
