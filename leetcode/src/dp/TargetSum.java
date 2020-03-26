package dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums==null || nums.length==0){
            return 0;
        }

        return dfs(nums, 0, S, new HashMap<>());
    }

    private int dfs(int[] nums, int index, int sum, Map<String,Integer> map){
        String str = index + ":"+sum;
        if(map.containsKey(str)){
            return map.get(str);
        }

        if(index==nums.length){
            return sum ==0?1:0;
        }

        int add = dfs(nums, index+1, sum+nums[index], map);
        int sub = dfs(nums, index+1, sum-nums[index], map);

        map.put(str, add+sub);

        return add+sub;
    }
}
