package design;

import java.util.LinkedList;
import java.util.TreeMap;

class HitCounter {

    /** Initialize your data structure here. */
    LinkedList<Integer> q = new LinkedList<>();
    public HitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && q.peekFirst()+300<=timestamp){
            q.pollFirst();
        }

        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */