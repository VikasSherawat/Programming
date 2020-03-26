package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Permutations2 {
    List<List<Integer>> superset = new ArrayList<>();
    Set<String> set = new HashSet<>();
    int[] nums;

    public static void main(String[] args) {
        int[] a = {2,2,1,1};
        List<List<Integer>> ans = new Permutations2().permuteUnique(a);
        for(List<Integer> ls: ans){
            System.out.println(Arrays.toString(ls.toArray()));
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null || nums.length==0)
            return superset;

        this.nums = nums;
        List<Integer> ls = Arrays.stream(nums).boxed().collect(Collectors.toList());
        bt(ls, 0);
        return superset;
    }

    private void bt(List<Integer> subset, int pos){
        if(pos==nums.length && !set.contains(Arrays.toString(subset.toArray()))){
            superset.add(new ArrayList<>(subset));
            set.add(Arrays.toString(subset.toArray()));
            return;
        }

        for(int i=pos;i<subset.size();i++){
            if(i!=pos){
                if(subset.get(i).equals(subset.get(pos))){
                    continue;
                }
            }
            Collections.swap(subset,i,pos);
            bt(subset,pos+1);
            Collections.swap(subset,i,pos);
        }
    }
}
