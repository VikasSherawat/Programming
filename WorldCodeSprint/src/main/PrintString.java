package main;

import java.util.*;
public class PrintString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] result = new int[T];
		for (int i = 0; i < T; i++) {
			int N =in.nextInt(),addC=in.nextInt(),appC=in.nextInt();
			String S = in.next();
			result[i]=findMinCost(N,addC,appC,S);
		}
		for(int i: result){
			System.out.println(i);
		}
	}

	private static int findMinCost(int n, int addC, int appC, String s) {
		// TODO Auto-generated method stub
		String inp = String.valueOf(s.charAt(0));
		int cost = addC;
		//System.out.println(inp.length());
		boolean aFlag,pFlag;
		int len =0;
		for(int i=1;inp.length()!=n;i++){
			int count=1;
			aFlag = true;pFlag=false;
			while(i+count<=n && inp.contains(s.substring(i, i+count)))
			{
				aFlag = false; pFlag= true;
				count++;
			}
			if(aFlag){
				cost+=addC;
				inp+=String.valueOf(s.charAt(i));
			}
			if(pFlag){
				len = i+--count;
				if(len>n)
					len =n;
				String temp = s.substring(i, len); 
				if(temp.length()*addC>appC){
					cost+=appC;
					inp+= temp;
					i=len-1;
				}else{
					cost+=addC;
					inp+=String.valueOf(s.charAt(i));
				}
			}
		}
		return cost;
	}

}
