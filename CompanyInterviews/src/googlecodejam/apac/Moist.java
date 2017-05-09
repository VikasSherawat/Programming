package googlecodejam.apac;

import java.io.*;
import java.util.*;


public class Moist {
	static final String FILENAME = "practice-2";
	static final String QUESTION = "C-";
	static final String SIZE = "small-";
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
		int N = in.nextInt();
		in.nextLine();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextLine();
		}
		ans = sort(arr);
		fpl(FORMAT + TURN + SEMICOLON + ans);
	}

	private int sort(String[] arr) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while(j>0 && arr[j].compareTo(arr[j-1])<0){
				String curr = arr[j];
				String prev = arr[j-1];
				if(curr.compareTo(prev)<0)
					exch(arr,j,j-1);
				else
					break;
				j--;
			}
			if(j!=i)
				count++;
		}
		return count;
	}

	private void exch(String[] arr, int j, int i) {
		// TODO Auto-generated method stub
		String temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		
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
		new Moist().run();
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
