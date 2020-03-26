package twopointer;

public class NiceSubArray {
    public static void main(String[] args) {
        int[] a = {1,1,2,1,1};
        int ans =  new NiceSubArray().numberOfSubarrays(a,3);
        System.out.println(ans);
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int ans =0, l =nums.length, r =0;
        for(int i =0;i<l;i++){
            nums[i] = nums[i]%2==0?0:1;
            if(i>0)
                nums[i] += nums[i-1];
            if(nums[i]==k)
                ans++;
        }

        for(int i =0;i<l;i++){
            for(int j=i+1;j<l;j++){
                int sum = nums[j]-nums[i];
                if(sum==k)
                    ans++;
                else if(sum>k)
                    break;
            }
        }

        return ans;
    }
}
