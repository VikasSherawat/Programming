package dynamicProgramming;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class MandograForest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		//String file = "C:\\Users\\Vikas Kumar\\Downloads\\MandograForest.txt";
		//PrintWriter pw = new PrintWriter(new File(file));
		while(T-->0){
			int N = Integer.parseInt(in.readLine());
			String[] inp = in.readLine().split("\\s+");
			BigInteger[] health = new BigInteger[inp.length];
			BigInteger totalSum = BigInteger.ZERO;
			for (int i = 0; i < inp.length; i++) {
				health[i] = new BigInteger(inp[i]);
				totalSum = totalSum.add(health[i]);
			}
			Arrays.sort(health);
			BigInteger exp = findMaxExperience(health,totalSum);
			System.out.println(exp);
			//pw.println(exp);
			
		}
		
		//pw.flush();
		//pw.close();
		
	}

	private static BigInteger findMaxExperience(BigInteger[] health, BigInteger totalSum) {
		// TODO Auto-generated method stub
		BigInteger exp = totalSum;
		int cExp = 1;
		BigInteger sumTillNow = BigInteger.ZERO;
		for (int i = 0; i < health.length; i++) {
			sumTillNow =  sumTillNow.add(health[i]);
			if((totalSum.subtract(sumTillNow)).multiply(BigInteger.valueOf(cExp+1)).compareTo(exp)>0){
				exp = (totalSum.subtract(sumTillNow)).multiply(BigInteger.valueOf(cExp+1));
				cExp++;
			}else
				break;
			//maxExp = Math.max(maxExp, exp);
		}
		
		
		
		return exp;
	}
}
