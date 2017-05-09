package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class countingsort3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String inp;
	        int[] ar = new int[n];
	        ArrayList<String> list = new ArrayList<String>();
	        for(int i=0;i<2*n;i++){
	        	inp = in.next();
	        	list.add(inp);
	        }
	        String intChar[];
	      int j=0;
	        for (int i = 0; i < list.size(); i=i+2) {
				intChar = list.get(i).split("\\s+");
				//System.out.println("IntChar value is--"+intChar);
				ar[j++]= Integer.parseInt(intChar[0]);
			}
	      countSort(ar);
		}

		private static void countSort(int[] ar) {
			// TODO Auto-generated method stub
			int[] inp = new int[100];
			int[] inp1 = new int[100];
			for (int i = 0; i < ar.length; i++) {
				int count = ar[i];
				if(inp[count]==0)
				inp[count]=1;
				else
					inp[count]=inp[count]+1;
			}
			for (int i = 0; i < inp1.length; i++) {
				int total=0;
				if(i<ar.length)
					{
					total =	findCount(inp,i);
					inp1[i]=total;
					}
				else
					inp1[i]=ar.length;
			}
			
			int size = ar.length;
			if(size>=100)
				size=100;
			
			 for(int n = 0;n<100;n++){
			      System.out.print(inp1[n]+" ");
			   }
			     System.out.println("");
		}

		private static int findCount(int[] inp, int i) {
			// TODO Auto-generated method stub
			int total=0;
			for (int j = 0; j <=i; j++) {
				total+=inp[j];
			}
			return total;
		}

}