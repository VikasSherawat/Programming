package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
    public static void main(String[] args) {
        List<List<Interval>> ls = new ArrayList<>();
        List<Interval> a = new ArrayList<>();
        a.add(new Interval(1,2));
        a.add(new Interval(5,6));
        ls.add(a);
        a = new ArrayList<>();
        a.add(new Interval(1,3));
        ls.add(a);
        a = new ArrayList<>();
        a.add(new Interval(4,10));
        ls.add(a);
        List<Interval> ans = new EmployeeFreeTime().employeeFreeTime(ls);
        for(Interval it : ans){
            System.out.println(it);
        }
    }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ls = new ArrayList<>();
        for(List<Interval> list: schedule){
            ls.addAll(list);
        }

        Collections.sort(ls, (a, b)->a.start!=b.start?a.start-b.start:a.end-b.end);
        List<Interval> merge = new ArrayList<>();
        List<Interval> out = new ArrayList<>();
        Interval first = null;
        for(int i = 0;i<ls.size();) {
            first = ls.get(i);
            int j = i + 1;
            for (; j < ls.size(); j++) {
                Interval second = ls.get(j);
                if (!overlap(first, second)) {
                    merge.add(first);
                    break;
                } else {
                    first = new Interval(first.start, Math.max(first.end, second.end));
                }
            }
            i = j;
        }
        merge.add(first);

        for(int i = 1;i<merge.size();i++){
            Interval prev = merge.get(i-1);
            Interval curr = merge.get(i);
            out.add(new Interval(prev.end,curr.start));
        }
        return out;
    }

    private boolean overlap(Interval f, Interval s){
        return s.start >=f.start && s.start <= f.end;

    }
}

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
