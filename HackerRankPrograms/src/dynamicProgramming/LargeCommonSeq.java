package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LargeCommonSeq {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			String[] inp = br.readLine().split("\\s+");
			String a = br.readLine();
			String b = br.readLine();
			int len = new LargeCommonSeq().LCS(a,b);
			System.out.println(len);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int LCS(String a, String b) {
		// TODO Auto-generated method stub
		int[][] lcs = new int[b.length()+1][a.length()+1];
		for (int i = 1; i <lcs.length ; i++) {
			int len = lcs[i].length;
			for (int j = 1; j < len; j++) {
				char ac = a.charAt(j-1);
				char bc = b.charAt(i-1);
				if(ac == bc){
					lcs[i][j] = lcs[i-1][j-1]+1;
				}else{
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		return lcs[a.length()][b.length()];
	}
}
