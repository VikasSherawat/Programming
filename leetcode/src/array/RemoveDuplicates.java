package array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int idx=0,k=0;
        for(int i=1;i<nums.length;){
            if(nums[i]==nums[i-1]){
                // first different element
                int j =i+1;
                k=idx;
                while(j<nums.length && nums[j]==nums[j-1]){
                    j++;
                }
                if(j<nums.length && idx+1<nums.length) {
                    nums[idx+1] = nums[j];
                    k++;
                }
                idx=i;
                i=j+1;
            }else{
                idx=i;
                i++;
            }


        }
        return k;
    }

    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        int n = new RemoveDuplicates().removeDuplicates(a);
        for (int i = 0; i <=n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
