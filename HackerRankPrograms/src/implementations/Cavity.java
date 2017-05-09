package implementations;

import java.util.ArrayList;
import java.util.Scanner;

public class Cavity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[][] ar = new int[n][n];
	        int[][] ar1 = new int[n][n];
	        ArrayList<String> list = new ArrayList<String>();
	        for (int i = 0; i < n; i++) {
	        	String num = in.next();
				list.add(num);
				
			}
	        for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ar[i][j] = Character.getNumericValue(list.get(i).charAt(j));
					ar1[i][j]=ar[i][j];
				}
			}
	        

	        //System.out.println("Length of the array is--"+ar.length);
	        for (int i = 1; i < ar.length-1; i++) {
				for (int j = 1; j < ar.length-1; j++) {
					if(ar[i][j]>ar[i][j-1]&&ar[i][j]>ar[i][j+1]&&ar[i][j]>ar[i+1][j]&&ar[i][j]>ar[i-1][j])
						ar1[i][j]=-1;
				}
			}
	        
	       // System.out.println("Final result");
	        for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length; j++) {
					if(ar1[i][j]!=-1)
						System.out.print(ar1[i][j]);
					else
						System.out.print("X");
				}
				System.out.println();
			}
	        
	        
	}

}
