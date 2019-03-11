package com.rms.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] tmp = email.split("@");
            StringBuilder sb = new StringBuilder();
            for (char c : tmp[0].toCharArray()) {
                if (c == '.') {
                    continue;
                } else if (c == '+') {
                    break;
                } else {
                    sb.append(c);
                }
            }
            sb.append(tmp[1]);
            set.add(sb.toString());
        }

        return set.size();
    }
}
