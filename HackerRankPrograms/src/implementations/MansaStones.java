package implementations;

import java.util.Scanner;

public class MansaStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			solve(N,Math.min(a, b),Math.max(a, b));
		}

	}

	private static void solve(int n, int a, int b) {
		// TODO Auto-generated method stub
		
		int min = (n-1)*a;
		int max = (n-1)*b;
		int diff = b-a;
		if(diff==0){
			System.out.println(min);
			return;
		}
		while(min<=max){
			System.out.print(min+" ");
			min += diff;
		}
		System.out.println();
	}

}
