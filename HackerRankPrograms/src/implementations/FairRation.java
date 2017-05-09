package implementations;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FairRation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int B[] = new int[N];
		int sum = 0;
		for (int B_i = 0; B_i < N; B_i++) {
			int i = in.nextInt();
			B[B_i] = i;
			sum += i;
		}
		if(sum%2==1){
			System.out.println("NO");
			return;
		}
		
		distributeRation(B);
	}

	private static void distributeRation(int[] b) {
		// TODO Auto-generated method stub
		long ans = 0l;
		if(b[b.length-1]%2==1){
			b[b.length-1]++;
			b[b.length-2]++;
			ans++;
		}
		for (int i = 0; i < b.length-2; i++) {
			int c = b[i];
			if(c%2==1){
				b[i]++;
				b[i+1]++;
				ans++;
			}
		}
		
		System.out.println(2*ans);
	}

}
