package mathematics;

import java.util.Scanner;

public class StrangeGrid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long row = in.nextLong();
		long col = in.nextLong()-1;
		long[] even = {0,2,4,6,8};
		long[] odd =  {1,3,5,7,9};
		if(row%2==0)
		{
			row=row/2-1;
			System.out.println(10*row+odd[(int)col]);
		}else{
			row/=2;
			System.out.println(10*row+even[(int)col]);
		}
		
	}

}
