package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {1,2,5,4,3};
        List<Integer> ans = new QuickSort().sortArray(a);
        System.out.println(Arrays.toString(ans.toArray()));
    }
    public List<Integer> sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(nums, lo, hi);
            sort(nums, lo, pi - 1);
            sort(nums, pi + 1, hi);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);  // Index of smaller element
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;    // increment index of smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i+1;
    }

    private void swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}
