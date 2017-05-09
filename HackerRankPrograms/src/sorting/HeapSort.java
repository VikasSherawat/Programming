package sorting;

import java.util.Scanner;

public class HeapSort {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for(int i=0;i<N;i++){
			arr[i]=in.nextInt();
		}
		heapsort(arr,arr.length);
	}
	
	static void heapsort(int a[], int length)
	{
	  buildheap(a, length);
	  int heapsize, i, temp;
	  heapsize = length - 1;
	  for( i=heapsize; i >= 0; i--)
	  {
	    temp = a[0];
	    a[0] = a[heapsize];
	    a[heapsize] = temp;
	    heapsize--;
	    satisfyheap(a, 0, heapsize);
	  }
	  for( i=0; i < length; i++)
	  {
	    System.out.print(a[i]+" ");
	  }
	}

	static	void buildheap(int a[], int length)
	{
	  int i, heapsize;
	  heapsize = length - 1;
	  for( i=(length/2); i >= 0; i--)
	  {
	    satisfyheap(a, i, heapsize);
	  } 
	}

	static void satisfyheap(int a[], int i, int heapsize)
	{
	  int l, r, largest, temp;
	  l = 2*i;
	  r = 2*i + 1;
	  if(l <= heapsize && a[l] > a[i])
	  {
	    largest = l;
	  }
	  else
	  {
	    largest = i;
	  }
	  if( r <= heapsize && a[r] > a[largest])
	  {
	    largest = r;
	  }
	  if(largest != i)
	  {
	    temp = a[i];
	    a[i] = a[largest];
	    a[largest] = temp;
	    satisfyheap(a, largest, heapsize);
	  }
	}
}
