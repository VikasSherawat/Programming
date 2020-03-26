package array;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    /*
    Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

    Return the intersection of these two interval lists.

    (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
    The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
     */

    public int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> ls = new ArrayList<>();
        for (int[] first : a) {
            for (int[] second : b) {
                if (isOverLapping(first, second)) { // checking
                    int[] temp = {Math.max(first[0], second[0]), Math.min(first[1], second[1])};
                    ls.add(temp);
                }
            }
        }
        int[][] out = new int[ls.size()][2];
        int i =0;
        for(int[] arr: ls){
            out[i++] = arr;
        }
        return out;
    }

    private boolean isOverLapping(int[] a, int[] b) {
        return (b[0] >= a[0] && b[0] <= a[1]) || (a[0] >= b[0] && a[0] <= b[1]) || (b[1] >= a[0] && b[1] <= a[1]) || (a[1] >= b[0] && a[1] <= b[1]);
    }
}
