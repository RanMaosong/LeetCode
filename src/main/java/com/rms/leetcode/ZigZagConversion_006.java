package com.rms.leetcode;

import java.io.CharArrayReader;
import java.util.ArrayList;

public class ZigZagConversion_006 {
    public static void main(String[] args) {
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        char[] chars = s.toCharArray();
        StringBuilder[] strArray = new StringBuilder[numRows];
        for (int i=0; i< strArray.length; ++i)
            strArray[i] = new StringBuilder();
        StringBuilder str = new StringBuilder();
        int j = (numRows - 1) * 2;
        int n = s.length();
        for (int i=0; i<n; i+=j) {
            for (int x=0; x<numRows; ++x) {
                int first = i + x, second = i + j -x;
                if (first < n)
                    strArray[x].append(chars[first]);
                if (second<n && second < i + j && second != first)
                    strArray[x].append(chars[second]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder lineStr: strArray)
            result.append(lineStr);

        return result.toString();
    }
    public static String convert1(String s, int numRows) {
        if (numRows == 1)
            return s;
        char[] chars = s.toCharArray();
        int j = (numRows - 1) * 2;
        int n = s.length();
        StringBuilder result = new StringBuilder();
        for (int row=0; row<numRows; ++row) {
            for (int i=0; i<n; i+=j) {
                int first = i + row, second = i + j - row;
                if (first < n)
                    result.append(chars[first]);
                if (second<n && second < i + j && second != first)
                    result.append(chars[second]);
            }
        }

        return result.toString();
    }
}
