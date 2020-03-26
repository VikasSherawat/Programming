package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length==0)
            return ans;

        List<Integer> ls = Arrays.stream(nums).boxed().collect(Collectors.toList());
        bt(ls,nums, 0);
        return ans;
    }

    private void bt(List<Integer> subset, int[] nums, int pos){
        if(pos == nums.length)
            ans.add(new ArrayList<>(subset));

        for(int i =pos;i<nums.length;i++){
            Collections.swap(subset,i, pos);
            bt(subset, nums, pos+1);
            Collections.swap(subset,i, pos);
        }
    }
}
