package main.mathematics;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RoadsNum {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int count =1;
		while(in.hasNextInt()){
			int N = in.nextInt();
			int R = in.nextInt();
			
			if(N==0 && R==0){
				return;
			}else{
				new RoadsNum().findSuffix(N,R,count++);
			}
		}
	}

	void findSuffix(int N, int R, int count) {
		// TODO Auto-generated method stub
		N -= R;
		int sR = N%R==0?N/R:(N/R)+1;
		if(sR>26){
			System.out.println("Case "+count+": Impossible");
			return;
		}else{
			System.out.println("Case "+count+": "+sR);
		}
	}

}
