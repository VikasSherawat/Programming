package sorting;

import java.util.*;

public class SelectionSort {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	int arr[] = new int[N];
	for(int i=0;i<N;i++){
		arr[i]=in.nextInt();
	}
	SelectionSort(arr);
	printArray(arr);
}

private static void SelectionSort(int[] arr) {
	// TODO Auto-generated method stub
	int min,temp=0,len=arr.length;
	for (int i = 0; i < len-1; i++) {
		min=arr[i];temp=-1;
		for (int j = i+1; j < len; j++) {
			if(min>=arr[j]){
				temp = j;
				min = arr[j];
			}
		}//inner for loop ends here
		if(temp!=-1){
		arr[temp]=arr[i];
		arr[i]=min;
		}
		printArray(arr);
	}
}

private static void printArray(int[] arr) {
	// TODO Auto-generated method stub
	for(int i:arr){
		System.out.print(i+" ");
	}
	System.out.println();
}
}
