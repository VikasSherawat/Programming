package greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class GridChallenge {
	static char[][] ar;
	static String[] str;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] result = new String[n];
		for (int i = 0; i < n; i++) {
			int s = in.nextInt();
			str = new String[s];
			ar = new char[s][s];
			for (int j = 0; j < str.length; j++) {
				str[j] = in.next();
			}
			
			for (int i1 = 0; i1 < str.length; i1++) {
				ar[i1]=sortString(str[i1]);
			}
			
			result[i] = findGrid(ar);
			
		}//outermost for loop closed
		
		
	for (String string : result) {
		System.out.println(string);
	}
		
	}
	private static String findGrid(char[][] ar2) {
		// TODO Auto-generated method stub
		boolean flag=false;
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				if(i!=ar.length-1 && j==ar.length-1) {
					if(ar[i][j]>ar[i+1][j]){
					flag=true;
					break;
				}
				}
				else if(j!=ar.length-1 && i==ar.length-1){
					if(ar[i][j]>ar[i][j+1]){
					flag=true;
					break;
				}
				}else if(j==ar.length-1 && i==ar.length-1)
					continue;
				else if(ar[i][j]>ar[i][j+1] || ar[i][j]>ar[i+1][j])
					{
					flag=true;
					break;
				}
					
			}
		}
		if(flag)
			return "NO";
			else
				return "YES";
	}
	
	private static char[] sortString(String string) {
		// TODO Auto-generated method stub
		char[] ar = string.toCharArray();
		char max = ar[0],temp;
		//System.out.println("Array length is---"+ar.length);
		for (int i = 0; i < ar.length-1; i++) {
			for (int j = 0; j < ar.length-1; j++) {
				if(ar[j]>ar[j+1]){
					temp = ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
				}
			}
		}
		/*System.out.println("Array after sorting is:--");
		for (char c : ar) {
			System.out.print(c+" ");
		}*/
		return ar;
	}


}
