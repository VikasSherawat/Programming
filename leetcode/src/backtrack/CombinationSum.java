package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> superset = new ArrayList<>();

    public static void main(String[] args) {
        int[] a = {2,3,6,7};
        List<List<Integer>> ans = new CombinationSum().combinationSum(a,7);
        for(List<Integer> ls: ans){
            System.out.println(Arrays.toString(ls.toArray()));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates,target, 0, new ArrayList<>());
        return superset;
    }
    private void combinationSum(int[] nums, int remain, int start, List<Integer> subset){
        if(remain<0){
            return;
        }else if(remain ==0){
            superset.add(new ArrayList<>(subset));
        }else{
            for (int i = start; i < nums.length; i++) {
                subset.add(nums[i]);
                combinationSum(nums,remain-nums[i],i,subset);
                subset.remove(subset.size()-1);
            }
        }
    }
}
