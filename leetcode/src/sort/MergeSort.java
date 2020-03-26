package sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {4,5,2,1,3};
        new MergeSort().sortArray(a);
        System.out.println(Arrays.toString(a));
    }

    public List<Integer> sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    private void mergesort(int[] arr, int lo, int hi){
        if(lo<hi){
            int mid = (lo+hi)>>>1;
            mergesort(arr,lo,mid);
            mergesort(arr,mid+1,hi);
            merge(arr,lo,mid,hi);
        }
    }

    private void merge(int[] arr, int lo, int mid, int hi){
        int[] temp = new int[hi-lo+1];
        int i =lo, j = mid+1, k =0;
        while(i<=mid && j<=hi){
            if(arr[i]<=arr[j]){
                temp[k] = arr[i++];
            }else{
                temp[k]=arr[j++];
            }
            k++;
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=hi){
            temp[k++]=arr[j++];
        }
        k=0;
        for(i = lo;i<=hi;i++){
            arr[i]=temp[k++];
        }
    }
}
