package com.rms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _008__String_to_Integer {

    public static void main(String[] args) {
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("   -42"));
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("words and 987"));
//        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-5-"));
    }
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('-', -1);
        map.put('+', 1);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('0', 0);
        long result = 0;
        int flag = 1;
        boolean isFirst= false;
        for (char c:chars) {
            if (c == ' ' && !isFirst)
                continue;
            else if (!map.containsKey(c)) {
                break;
            } else if (c == '-' || c == '+') {
                if (isFirst)
                    break;
                else
                    isFirst = !isFirst;
                flag = map.get(c);
            } else{
                isFirst= true;
                result = result * 10 + map.get(c);

            }
            if (flag * result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (flag * result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        System.out.print(flag + "    " + result + "  ==  ");
        result *= flag;
        if (!isFirst)
            return 0;
        else
            return (int)result;

    }
}
