package implementations;

import java.util.Scanner;

public class SherlockSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        int[] result = new int[T];
        for (int i = 0; i < T; i++) {
			int A = in.nextInt(),B=in.nextInt();
			//result[i]=findSquare(A,B);
			result[i] = (int)(Math.floor(Math.sqrt(B))-Math.ceil(Math.sqrt(A))+1);
		}
        
        for (int i : result) {
			System.out.println(i);
		}
	}

	private static int findSquare(int a, int b) {
		// TODO Auto-generated method stub
		int count=0;
		for (int i = a; i <=b; i++) {
			if(i%10==2 || i%10==3 || i%10==7 || i%10==8){
				continue;
			}else{
				if(Math.sqrt(i)%1==0)
				count++;
			}
		}
		return count;
	}

}
