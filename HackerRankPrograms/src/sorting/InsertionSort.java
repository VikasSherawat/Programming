package sorting;

import java.util.*;

public class InsertionSort {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	int arr[] = new int[N];
	for(int i=0;i<N;i++){
		arr[i]=in.nextInt();
	}
	insertionSort(arr);
	printArray(arr);
}

static void insertionSort(int[] arr){

	int len = arr.length;
	for(int i=1;i<len;i++){
	int temp;
		for(int j=0;j<i;j++){
			if(arr[i]<arr[j]){
				temp =arr[i];
				for(int k=i-1;k>=j;k--){
					arr[k+1]=arr[k];
				}
				arr[j]=temp;
				break;
			}
		}
	printArray(arr);
	}
}

private static void printArray(int[] arr) {
	// TODO Auto-generated method stub
	for(int i: arr){
		System.out.print(i+" ");
		}
	System.out.println();
	
}
}
