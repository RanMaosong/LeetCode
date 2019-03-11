package com.rms.leetcode;

public class Leetcode_937 {
    public String[] reorderLogFiles(String[] logs) {
        String[] res = new String[logs.length];
        int i=0, j = logs.length-1;
        for (String log : logs) {
            if (isDigit(log)) {
                res[j--] = log;
            } else {
                res[i++] = log;
            }
        }

        return res;
    }

    private boolean isDigit(String log) {
        char[] c = log.toCharArray();
        for (int i=0; i < c.length; ++i) {
            if (Character.isDigit(c[i]))
                return true;
            else if (Character.isLetter(c[i]))
                return false;
        }

        return true;
    }
}
