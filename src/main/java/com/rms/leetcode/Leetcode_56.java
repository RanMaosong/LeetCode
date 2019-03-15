package com.rms.leetcode;


import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Leetcode_56 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty())
            return new ArrayList<>();
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start)
                    return -1;
                else if (o1.start == o2.start)
                    return 0;
                else
                    return 1;
            }
        });

        for (Interval interval : intervals)
            System.out.print("(" + interval.start + "," + interval.end + ")");
        List<Interval> res  = new ArrayList<>();
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start > end) {
                Interval node = new Interval(start, end);
                res.add(node);
                start = interval.start;
                end = interval.end;
            } else {
               end = Math.max(end, interval.end);
            }
        }
        Interval node = new Interval(start, end);
        res.add(node);

        return res;
    }

//    private void quickSort(Interval[] arr, int i, int j) {
//        int l=i, r=j;
//        if ( r <= l)
//            return ;
//        else {
//            Interval p = arr[l++];
//            int cur = l;
//            while (l < r) {
//                if (arr[l].start <= p.start) {
//                    arr[cur++] = p;
//                    ++l;
//                } else {
//                    Interval tmp = arr[l];
//                    arr[l] = arr[r];
//                    arr[r--] = tmp;
//                }
//            }
//            arr[l] = p;
//            quickSort(arr, i, l-1);
//            quickSort(arr, l+1, j);
//        }
//    }

    public static void main(String[] args) {

    }
}
