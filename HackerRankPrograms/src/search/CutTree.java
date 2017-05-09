package search;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CutTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] weights = new int[N + 1];
		for (int i = 0; i < N; i++) {
			weights[i + 1] = in.nextInt();
		}
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		int root = -1;
		
		for (int i = 0; i < N - 1; i++) {
			int p = in.nextInt();
			int c = in.nextInt();
			if(root==-1)
				root = p;
			
			list.get(p).add(c);
			list.get(c).add(p);	
		}
		
		for (int i = 1; i <=N; i++) {
			System.out.println(i+" has "+(list.get(i).size()-1)+" children");
		}

	}


}

