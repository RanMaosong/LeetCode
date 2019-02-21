package com.rms.leetcode;

import java.util.*;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_690 {
    int importance = 0;
    Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Employee> q = new LinkedList<>();
        q.offer(map.get(id));
        while (!q.isEmpty()) {
            Employee e = q.poll();
            importance += e.importance;
            for (int i : e.subordinates) {
                q.offer(map.get(i));
            }
        }

        return importance;
    }
}
