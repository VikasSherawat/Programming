package googlecodejam.apac;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JaneFlower {
	
	static final String FILENAME = "A-large";
	    static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	    static final String IN       = FILEPATH + FILENAME + ".in";
	    static final String OUT      = FILEPATH + FILENAME + ".out";
	    Scanner  			in       ;
	    PrintWriter         out      ;
	    
	    private void solve() {
	    	int ans = 0;
	    	
	    	int M = in.nextInt();
	    	int[] arr = new int[M+1];
	    	for (int i = 0; i < arr.length; i++) {
				arr[i] = in.nextInt();
			}
	    	
	    	float profit = 0.0f;
	    	out.println(ans);
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
	    		out.print("Case #" + i + ": ");
	    		solve();
	    	}
	    	in.close();
	    	out.close();
	    }
	    
	    
	    public static void main(String args[]) throws Exception {
	    	new JaneFlower().run();
	    }
}
