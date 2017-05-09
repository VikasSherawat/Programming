package sorting;
import java.util.*;
public class BuildHeap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		int k=0;
		while(k<N){
			arr[k++]=in.nextInt();
		}
		
		buildHeap(arr);
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int i: arr){
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void buildHeap(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		int[] heap = new int[len];
		while(true){
		break;
		}
		
	}

}
