package googlecodejam.sixteen;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class JamCoin {
static final String FILENAME = "practice";
		static final String  QUESTION = "C-";
		static final String  SIZE = "large-";
		static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
		static final String IN       = FILEPATH + QUESTION+SIZE + FILENAME + ".in";
		static final String OUT      = FILEPATH + QUESTION+SIZE + FILENAME + "-answer.in";
		String FORMAT = "Case #";
		String SEMICOLON  = ":";
		Scanner  			in       ;
		PrintWriter        out      ;
		
		private void solve(int TURN) {
			int ans = 0;
			out.println(FORMAT+TURN+SEMICOLON);
			
			int N = in.nextInt(),
				J = in.nextInt();
			
			long runTime = (long) Math.pow(2, N - 2);
			
			Map<String,List<Integer>> map = new TreeMap<String, List<Integer>>();
			
			for (long i = 0; i <= runTime && J != map.size(); i++) {
				StringBuilder str = new StringBuilder();
				str.append("1");
				String binaryString = String
						.format("%" + Integer.toString(N - 2) + "s",
								Long.toBinaryString(i)).replace(" ", "0");
				str.append(binaryString);
				str.append("1");
				
				
				if (ifValidCoinJam(str)) {
					List<Integer> result = findDivisors(str);
					map.put(str.toString(), result);
				}

			}
			
			
			for(Map.Entry<String, List<Integer>> m: map.entrySet()){
				String coinJam = m.getKey();
				List<Integer> divisors = m.getValue();
				out.print(coinJam+" ");
				for (int i = 0; i < divisors.size(); i++) {
					out.print(divisors.get(i)+" ");
				}
				out.println();
			}
			
			
		}
		
		private List<Integer> findDivisors(StringBuilder str) {
			// TODO Auto-generated method stub
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 2; i < 11 ; i++) {
				BigInteger big = new BigInteger(str.toString(),i);
				
				for (int j = 2; j < 102 ; j++) {
					if(big.remainder(BigInteger.valueOf(j)).intValue()==0){
						list.add(j);
						break;
					}
				}
			}
			return list;
		}

		private boolean ifValidCoinJam(StringBuilder str) {
			// TODO Auto-generated method stub
			for (int i = 2; i < 11 ; i++) {
				BigInteger big = new BigInteger(str.toString(),i);
				if(big.remainder(BigInteger.valueOf(2)).intValue() == 0){
					continue;
				}
				if(!isValid(big)){
					return false;
				}
			}
			return true;
		}

		private boolean isValid(BigInteger big) {
			// TODO Auto-generated method stub
			for (long i = 3l; i <102 ; i = i+2) {
				if(big.remainder(BigInteger.valueOf(i)).intValue()==0)
					return true;
			}
			return false;
		}

		private void configOutput() {
			File file = new File(OUT);
			if (file.exists()) {
				file.delete();
			}
			try {
				out = new PrintWriter(new File(OUT));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void configInput() {
			// TODO Auto-generated method stub
			File file = new File(IN);
			try {
				in = new Scanner(file);
				//in = new Scanner(System.in);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void run() throws Exception {
			configInput();
			configOutput();
			int t = in.nextInt();
			for (int i = 1; i <= t; i++) {
				//out.print("Case #" + i + ": ");
				solve(i);
			}
			in.close();
			out.close();
		}
		
		
		public static void main(String args[]) throws Exception {
			new JamCoin().run();
		}
}
