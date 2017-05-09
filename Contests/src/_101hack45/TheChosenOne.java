package _101hack45;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class TheChosenOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long[] arr = new long[T];
		long gcd = 0l, lastGCD =0l;
		boolean removed = false;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextLong();
		}	
		Arrays.sort(arr);
		int start = 0;
		for (int i = start; i < arr.length; i++) {
			long temp = findGcd(Math.max(gcd,arr[i]),Math.min(gcd,arr[i]));
			if(temp!=1){
				if(temp<gcd){
					lastGCD = gcd;
				}
				gcd = temp;
				
			}else{
				removed = true;
			}
		}
		if(removed){
			System.out.println(gcd);
			return;
		}
		if(arr.length==1){
				System.out.println(gcd);
				return;
		}	
		if(findGcd(arr[1], arr[0]) < findGcd(arr[2], arr[1])){
			gcd =findGcd(arr[2], arr[1]) ;
			if(gcd>lastGCD)
				System.out.println(gcd);
			else{
				System.out.println(lastGCD);
			}
			return;
		}
		
		if(lastGCD==0){
				int count = 1;
				for (int i = 0; i < arr.length; i++) {
					if(arr[i]%gcd==0){
						if(count==2){
							System.out.println(arr[i]);
							return;
						}else{
							count++;
						}
					}			
					
				}
		}else{
			System.out.println(lastGCD);
		}
		
		
		
		
		
	}

	private static void findAns(long l, long gcd) {
		// TODO Auto-generated method stub
		if(l<gcd){
			System.out.println(-1);
			return;
		}
		while(true){
			if(l%gcd==0){
				System.out.println(gcd);
				return;
			}
			gcd++;
		}
	}

	private static long findGcd(long a, long b) {
		// TODO Auto-generated method stub
		if(b==0)
			return a;
		else
		return findGcd(b, a%b);
	}

}
