package com.rms.leetcode;

import java.util.*;

public class Leetcode_811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            System.out.println(Arrays.toString(s.split(".")));
            String[] tmp = s.split(" ");
            int num = Integer.valueOf(tmp[0]);
            tmp = tmp[1].split("\\.");
            String domain = "";
            for (int i = tmp.length-1; i >= 0; --i) {
                if (domain.equals("")) {
                    domain = tmp[i];
                } else {
                    domain = tmp[i] + "." + domain;
                }

                int count = map.getOrDefault(domain, 0);
                map.put(domain, count + num);
            }
        }

        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }

        return  res;
    }


    public static void main(String[] args) {
        new Leetcode_811().subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
    }
}
