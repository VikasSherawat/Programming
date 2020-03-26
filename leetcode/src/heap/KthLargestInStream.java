package heap;

import java.util.PriorityQueue;

public class KthLargestInStream {
    final PriorityQueue<Integer> q;
    final int k;

    public static void main(String[] args) {
        KthLargestInStream obj = new KthLargestInStream(3, new int[]{4,5,8,2});
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
    public KthLargestInStream(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
}
