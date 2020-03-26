package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {

    public int findKthLargest(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n : nums){
            minHeap.offer(n);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    public static void main(String[] args) {
        int[] n = {3,2,3,1,2,4,5,5,6};
        int ans = new KthLargest().findKthLargest(n,4);
        System.out.println(ans);
    }
}
