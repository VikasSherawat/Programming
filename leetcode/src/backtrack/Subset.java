package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    private List<List<Integer>> superset = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();

    public static void main(String[] args) {
        int[] n = {1,2,3};
        List<List<Integer>> ans= new Subset().subsets(n);
        for(List<Integer> a: ans){
            System.out.println(Arrays.toString(a.toArray()));
        }
        System.out.println(ans.size());
    }

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(new ArrayList<>(),nums,0);
        return superset;
    }

    private void backTrack(List<Integer> subset, int[] nums, int start){
        //condition to add to result
        superset.add(new ArrayList<>(subset));


        // condition to return/break;

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backTrack(subset, nums, i+1);
            subset.remove(subset.size()-1);
        }
    }
}
