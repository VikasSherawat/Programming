package googlecodejam.sixteen;

import java.io.*;
import java.util.*;

public class TheLastWord {
static final String FILENAME = "practice";
		static final String  QUESTION = "A-";
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
			char[] ch = in.next().toCharArray();
			StringBuilder sb = new StringBuilder();
			sb.append(ch[0]);
			for (int i = 1; i < ch.length; i++) {
				char prev = sb.charAt(0);
				if(prev > ch[i]){
					sb.append(ch[i]);
				}else{
					sb.insert(0, ch[i]);
				}
			}
			
			out.println(FORMAT+TURN+SEMICOLON+sb.toString());
			//System.out.println(FORMAT+TURN+SEMICOLON+sb.toString());
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
			new TheLastWord().run();
		}
}
