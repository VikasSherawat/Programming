package twopointer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AtMostK {

    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        int[] a = {1,2,1,2,3};
        int ans = new AtMostK().atMost(a,2);
        System.out.println(ans);
    }

    private int exactlyK(int[] arr, int k){
        return atMost(arr,k)-atMost(arr,k-1);
    }
    private int atMost(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
