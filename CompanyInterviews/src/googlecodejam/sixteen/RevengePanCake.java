package googlecodejam.sixteen;

import java.io.*;
import java.util.*;



public class RevengePanCake {
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
	    
	    private void solve(int turn) {
	    	int ans = 0;
	    	char[] ch = in.next().toCharArray();
	    	char N = '-',
	    		 P = '+';
	    	int sN = -1, eN = -1;
	    	int sP = -1, eP = -1;
	    	
	    	for (int i = 0; i < ch.length; i++) {
	    		char curr = ch[i];
	    		if(curr == N){
	    			if(sN == -1){
	    				sN = i;
	    			}
	    				eN = i + findNext(ch,i,N);
	    				i = eN;
	    			
	    			if(sP!=-1){
	    				Arrays.fill(ch, sN,eN+1,P);
	    				ans += 2;
	    				sN= eN = -1;
	    			}else{
	    				Arrays.fill(ch, sN,eN+1,P);
	    				sN= eN = -1;
	    				ans += 1;
	    			}
	    		}else{ //if the current character is positive
	    			if(sP == -1){
	    				eP = sP = i;
	    				
	    			}else{
	    				eP = i + findNext(ch,i,P);
	    				i = eP;
	    			}
	    			
	    			
	    		}
			}
	    	
	    	out.println(FORMAT+turn+SEMICOLON+ans);
	    	//System.out.println(Arrays.toString(ch));
	    	//System.out.println(FORMAT+turn+SEMICOLON+ans);
	    }
	    
	    private int findNext(char[] ch, int i, char n) {
			// TODO Auto-generated method stub
	    	int count =0;
	    	for (int j = i; j < ch.length; j++) {
				if(ch[j]==n)
					count++;
				else
					break;
			}
			return --count;
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
	    	out.flush();
	    	out.close();
	    }
	    
	    
	    public static void main(String args[]) throws Exception {
	    	new RevengePanCake().run();
	    }
}
