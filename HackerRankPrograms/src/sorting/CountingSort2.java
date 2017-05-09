package sorting;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class CountingSort2 {


    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int[] ar = new int[n];
         for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
         }
         sortArray(ar);
     }

	private static void sortArray(int[] ar) {
		// TODO Auto-generated method stub
		SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < ar.length; i++) {
			if(map.containsKey(ar[i]))
				map.put(ar[i], map.get(ar[i])+1);
			else
				map.put(ar[i], 1);
		}
			
		for(Map.Entry m1: map.entrySet()){
			for (int i = 0; i < (Integer)m1.getValue(); i++) {
				System.out.print(m1.getKey()+" ");
			}
		}
	} 
  
}
