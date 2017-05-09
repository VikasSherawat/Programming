package sorting;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class CountingSort1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
           ar[i]=in.nextInt(); 
        }
        
        countSort(ar);
	}
	private static void countSort(int[] ar) {
		// TODO Auto-generated method stub
		int[] inp = new int[100];
		for (int i = 0; i < ar.length; i++) {
			int count = ar[i];
			if(inp[count]==0)
			inp[count]=1;
			else
				inp[count]=inp[count]+1;
		}
		 for(int n: inp){
		      System.out.print(n+" ");
		   }
		     System.out.println("");
	}

}
