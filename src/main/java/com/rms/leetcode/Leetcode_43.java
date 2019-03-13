package com.rms.leetcode;

import java.util.Arrays;

public class Leetcode_43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        char[] a = num1.toCharArray(), b =  num2.toCharArray();
        char[] res = new char[]{'0'};
        for (int i = b.length-1, j =0; i >= 0; --i, ++j) {
            String tmp = multi(a, b[i]-48, j);
//            System.out.print(tmp);
            res = add(tmp.toCharArray(), res).toCharArray();
//            System.out.println(Arrays.toString(res));
        }

        return new String(res);
    }

    private String multi(char[] num1, int num2, int zeros) {
//        System.out.println(Arrays.toString(num1)+ num2);
        if (num2 == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < zeros; ++i)
            sb.append("0");
        int jinwei = 0;
        for (int i=num1.length-1; i >= 0; --i) {
            int num = num1[i] - 48;
            num = num * num2 + jinwei;
            sb.append(num % 10);
            jinwei = num / 10;
        }
        if (jinwei != 0)
            sb.append(jinwei);

        return sb.reverse().toString();
    }

    private String add(char[] num1, char[] num2) {
        System.out.println(Arrays.toString(num1) + Arrays.toString(num2));
        StringBuilder sb = new StringBuilder();
        int i = num1.length-1, j = num2.length - 1, jinwei = 0;
        while (i >=0 && j >= 0) {
            int a = num1[i] - 48, b = num2[j] - 48;
            a = a + b + jinwei;
            sb.append(a % 10);
            jinwei = a / 10;
            --i;
            --j;
        }
        if (j > 0) {
            num1 = num2;
            i = j;
        }

        while (i >= 0) {
            int a = num1[i] - 48 + jinwei;
            sb.append(a % 10);
            jinwei = a / 10;
            --i;
        }
        if (jinwei != 0)
            sb.append(jinwei);

        return sb.reverse().toString();
    }

    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        if ("1".equals(num1))
            return num2;
        if ("1".equals(num2))
            return num1;

        int n1 = num1.length(), n2 = num2.length(), t = n1 + n2 - 2;
        int[] res = new int[t+1];
        for (int i=0; i < n1; ++i) {
            int a = num1.charAt(i) - '0';
            for (int j=0; j < n2; ++j) {
                int b = num2.charAt(j) - '0';
                res[t - i- j] += a * b;
            }
        }
        StringBuilder sb = new StringBuilder();
        int jinwei = 0;
        for (int num : res) {
            sb.append((num + jinwei) % 10);
            jinwei = (num + jinwei) / 10;
        }

        if (jinwei != 0)
            sb.append(jinwei);
        return sb.reverse().toString();


    }

    public static void main(String[] args) {
        Leetcode_43 lt = new Leetcode_43();
        System.out.println(lt.multiply2("123", "456"));
    }


}
