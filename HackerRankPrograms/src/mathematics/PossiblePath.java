package mathematics;

import java.util.Scanner;

public class PossiblePath {

	/**
	 * @param args
	 * 
3
1 1 2 3
2 1 2 3
3 3 1 1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[4];
		String[] out = new String[n];
		for (int j = 0; j < n; j++) {
			int a,b,x,y;
		for (int i = 0; i < ar.length; i++) {
			ar[i]=in.nextInt();
	}
		a=ar[0];
		b=ar[1];
		x=ar[2];
		y=ar[3];
		if((x-a)%b==0 && (y-b)%b==0)
			out[j]="YES";
		else
			out[j]="NO";
		}//outer for loop
		for(String inp: out){
			System.out.println(inp);
		}
	}
}
