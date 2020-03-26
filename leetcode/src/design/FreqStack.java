package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

class FreqStack {
    public static void main(String[] args) {
        FreqStack st = new FreqStack();
        st.push(5);
        st.push(7);
        st.push(5);
        st.push(7);
        st.push(4);
        st.push(5);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }

    private Map<Integer,Integer> freq;
    private Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
    }

    public void push(int x) {
        int f = freq.getOrDefault(x,0)+1;
        freq.put(x,f);
        if(f >maxFreq)
            maxFreq =f;

        group.computeIfAbsent(f, z->new Stack<>()).add(x);
    }

    public int pop() {

        int n = group.get(maxFreq).pop();
        freq.put(n, freq.get(n) - 1);
        if(group.get(maxFreq).size()==0)
            --maxFreq;

        return n;
    }

}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */