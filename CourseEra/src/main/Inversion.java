package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inversion {
	static long inv =0;
	private static String PATH = "C:\\Users\\Vikas Kumar\\Documents\\Programming\\stanford\\input.txt";
	public static void main(String[] args) {
		int[] arr = new int[100000];
		int[] result = new int[100000];
		try {
			Scanner in = new Scanner(new File(PATH));
			int count=0;
			while(in.hasNext()){
				arr[count++] = in.nextInt();
			}
			
			divide(arr,0,arr.length-1);
			System.out.println(inv);
			//printArray(arr);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	private static void divide(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		
		if(start >= end)
			return;
		int size = (start+end)/2;
		divide(arr, start, size);
		divide(arr, size+1, end);
		mergeArray(arr,start,size,end);
		
	}

	private static void mergeArray(int[] arr, int start, int split, int end) {
		// TODO Auto-generated method stub
		int[] cArr = new int[arr.length];
		int i=start,j=split+1,k=0;
		/*
		 runs through two arrays
		 first one scans from start to split index
		 second array scans from split+1 to end index	
		*/	
		while(i<=split && j <=end){
			if(arr[i]<arr[j]){//if element from 1st array is smaller
				cArr[k++]=arr[i++]; // that element goes to the backup array
			}else{
				inv++;
				cArr[k++]=arr[j++]; //else element from second half goes to the backup array
			}
		}//while ends here
		
		while(i <= split)
		  {
		    cArr[k++] = arr[i++];
		  }
		  
		  while(j <= end)
		  {
			  cArr[k++] = arr[j++];
		  }
		  
		  for(i=end; i >= start; i--)
		  {
		    arr[i] = cArr[--k];        // copying back the sorted list to a[]
		  }
		 // printArray(arr);
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int i:arr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
