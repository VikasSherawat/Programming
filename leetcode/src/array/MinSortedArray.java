package array;

public class MinSortedArray {
    public int findMin(int[] nums) {
        int lo =0,hi = nums.length-1;
        while(lo<hi){
            int m = (lo+hi)/2;
            if(m>0 && m<nums.length-1 && nums[m]<nums[m-1] && nums[m]<nums[m+1]){
                return nums[m];
            }else if(m>0 && m<nums.length-1 && nums[m]>nums[m-1] && nums[m]>nums[m+1]){
                return nums[m+1];
            }else if(nums[m]>=nums[lo]){
                lo = m+1;
            }else{
                hi = m;
            }
        }

        return nums[lo];
    }

    public static void main(String[] args) {
        int[] n = {2};
        int ans = new MinSortedArray().findMin(n);
        System.out.println(ans);
    }

}
