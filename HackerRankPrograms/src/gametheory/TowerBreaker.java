package gametheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TowerBreaker {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int M = in.nextInt();
			if(N%2==0){
				System.out.println("2");
			}else{
				if(M==1)
					System.out.println(2);
				else
				System.out.println("1");
			}
		}
	}
}
