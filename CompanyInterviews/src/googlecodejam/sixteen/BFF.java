package googlecodejam.sixteen;

import java.io.*;
import java.util.*;


public class BFF {
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
			
			int N = in.nextInt();
			int[] bff = new int[N];
			for (int i = 0; i < N; i++) {
				bff[i] = in.nextInt()-1;
			}
			
			int[] test = new int[N];

			int ans1 = 0;
			int ans2 = 0;

			int[] was = new int[N];
			for (int i = 0; i < N; i++) {
				int cur = 0;
				Arrays.fill(was, 0);
				int x = i;
				while (was[x] == 0) {
					cur++;
					was[x] = cur;
					x = bff[x];
				}
				int cycle = cur - was[x] + 1;
				if (cycle == 2) {
					if (cur > test[x]) {
						ans2 += cur - test[x];
						test[x] = cur;
						if (test[bff[x]] == 0)
							test[bff[x]] = 2;
					}
				} else {
					ans1 = Math.max(ans1, cycle);
				}
			}
			int ans = Math.max(ans1, ans2);		
			pl(FORMAT+TURN+SEMICOLON+ans);
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
				//in = new Scanner(file);
				in = new Scanner(System.in);
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
			new BFF().run();
		}
		
		public void pl(String inp){
			System.out.println(inp);
		}
		
		public void p(String inp){
			System.out.print(inp);
		}
		
		public void fpl(String inp){
			out.println(inp);
		}
		
		public void fp(String inp){
			out.print(inp);
		}
}
