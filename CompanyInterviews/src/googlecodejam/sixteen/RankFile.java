package googlecodejam.sixteen;

import java.io.*;
import java.util.*;


public class RankFile {
static final String FILENAME = "practice";
		static final String  QUESTION = "B-";
		static final String  SIZE = "large-";
		static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
		static final String IN       = FILEPATH + QUESTION+SIZE + FILENAME + ".in";
		static final String OUT      = FILEPATH + QUESTION+SIZE + FILENAME + "-answer.in";
		String FORMAT = "Case #";
		String SEMICOLON  = ": ";
		Scanner  			in       ;
		PrintWriter        out      ;
		
		private void solve(int TURN) {
			int ans = 0;
			int N = in.nextInt();
			
			Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
			
			for (int i = 0; i < N*(2*N-1); i++) {
				int ele = in.nextInt();
				if(map.containsKey(ele)){
					map.put(ele, map.get(ele)+1);
				}else{
					map.put(ele, 1);
				}
			}
			StringBuilder sb = new StringBuilder();
			for(Map.Entry<Integer,Integer> m: map.entrySet()){
				int key = m.getKey();
				int  value = m.getValue();
				if(value%2==1){
					sb.append(key+" ");
				}
			}
			
			out.println(FORMAT+TURN+SEMICOLON+sb.toString());
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
			new RankFile().run();
		}
}
