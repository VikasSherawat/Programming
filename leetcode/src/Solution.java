import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
import java.util.stream.Collectors;

import sun.jvm.hotspot.utilities.IntegerEnum;

class Solution {
    /*
    Given an array of non-negative integers, you are initially positioned at the first
     index of the array. Each element in the array represents your maximum jump length
      at that position. Determine if you are able to reach the last index.
     */
    public static void main(String[] args) {
        int[] n = {5,2,6,1};
        List<Integer> ans = new Solution().countSmaller(n);
        for(int i: ans)
            System.out.println(i);

    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        ls.add(0);
        set.add(nums[nums.length-1]);
        for(int i =nums.length-2;i>=0;i--){
            set.add(nums[i]);
            int size = set.subSet(0,true,nums[i],false).size();
            ls.add(size);
        }
        Collections.reverse(ls);
        return ls;
    }
}
