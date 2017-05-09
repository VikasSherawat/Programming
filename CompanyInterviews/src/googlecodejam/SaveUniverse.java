package googlecodejam;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SaveUniverse {
	static final String FILENAME = "practice";
	static final String QUESTION = "A-";
	static final String SIZE = "large-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME
			+ "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;

	private void solve(int TURN) {
		int ans = 0;
		int S = in.nextInt();
		//List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		in.nextLine();
		//Map<String,Universe> map = new TreeMap<String, Universe>();
		for (int i = 0; i < S; i++) {
			String s = in.nextLine();
			set.add(s);
		}
		int Q = in.nextInt();
		in.nextLine();
		String[] arr = new String[Q];
		for (int i = 0; i < Q; i++) {
			String s= in.nextLine();
			arr[i] = s;		
		}
		
		ans = saveUniverse(set,arr);
		
		
		
		
		
		fpl(FORMAT + TURN + SEMICOLON + ans);
	}

	private int saveUniverse(Set<String> set, String[] arr) {
		// TODO Auto-generated method stub
		Set<String> dup = new HashSet<String>(set);
		boolean flag = false;
		int count =0;
		for (int i = 0; i < arr.length; i++) {
			if(dup.size()>0){
				if(dup.contains(arr[i]))
					dup.remove(arr[i]);
			}
			if(dup.size()==0){
				dup = new HashSet<String>(set);
				dup.remove(arr[i]);
				count++;
				flag = true;
			}
		}
		return count;
		
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
			// out.print("Case #" + i + ": ");
			solve(i);
		}
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new SaveUniverse().run();
	}

	public void pl(Object inp) {
		System.out.println(inp);
	}

	public void p(Object inp) {
		System.out.print(inp);
	}

	public void fpl(Object inp) {
		out.println(inp);
	}

	public void fp(Object inp) {
		out.print(inp);
	}
}
