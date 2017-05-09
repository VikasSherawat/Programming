package graph;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArtGallery {
	
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(in.readLine());
			while(T-->0){
				in.readLine();
				String[] VE = in.readLine().split("\\s+");
				int V = Integer.parseInt(VE[0]);
				int E = Integer.parseInt(VE[1]);
				List<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
				for (int i = 0; i < V; i++) {
					list.add(new HashSet<Integer>());
				}
				int[] arr = convertStringArray(in.readLine().split("\\s+"));
				for (int i = 0; i < E; i++) {
					String[] gallery = in.readLine().split("\\s+");
					int v1 = Integer.parseInt(gallery[0]);
					int v2 = Integer.parseInt(gallery[1]);
					list.get(v1).add(v2);
					list.get(v2).add(v1);
				}
				
				solve(list);
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void solve(List<HashSet<Integer>> list) {
		// TODO Auto-generated method stub
		
		
	}

	private static int[] convertStringArray(String[] split) {
		// TODO Auto-generated method stub
		int[] arr = new int[split.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		return arr;
	}
}
