package array;

public class FindKthLargest {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(new FindKthLargest().findKthLargest(arr,2));
    }
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1, nums.length-k);
    }

    private int quickSelect(int[] nums, int lo, int hi, int k){
        int res = nums[lo];
        if(lo<hi){
            int p = partition(nums,lo,hi);
            if(p==k){
                return nums[p];
            }
            if(k<p)
                res = quickSelect(nums,lo,p-1,k);
            else
                res = quickSelect(nums,p+1,hi,k);
        }
        return res;
    }

    private int partition(int[] nums, int lo, int hi){
        int pivot = nums[hi];
        int i = lo-1;
        for(int j= lo;j<=hi-1;j++){
            if(nums[j]<pivot){
                i++;
                swap(nums,i,j);
            }
        }

        swap(nums,i+1,hi);
        return i+1;
    }

    private void swap(int[] n, int a, int b){
        int temp = n[a];
        n[a]=n[b];
        n[b]=temp;
    }
}
