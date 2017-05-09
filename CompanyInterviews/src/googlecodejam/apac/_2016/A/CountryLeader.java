package googlecodejam.apac._2016.A;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountryLeader {
	static final String FILENAME = "practice";
	static final String QUESTION = "A-";
	static final String SIZE = "large-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME + "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;
	BufferedReader br;

	public int s2int(){
		return 0;
	}
	private void solve(int TURN) throws Exception {
		int ans = 0;
		int T = Integer.valueOf(br.readLine());
		TreeMap<String, Integer> map = new TreeMap<>();
		while(T-->0){
			String s= br.readLine();
			int[] arr = new int[255];
			int count = 1;
			for(int i =1;i<s.length();i++){
				if(s.charAt(i)!=' ' && s.indexOf(s.charAt(i))==i){
					count++;
				}
			}
			map.put(s, count);
		}
		String key="";
		int max = -1;
		for (Map.Entry<String, Integer> m : map.entrySet())
		{
			String kk = m.getKey();
			int val = m.getValue();
			if(val>max){
				max = val;
				key = kk;
			}
		}
		fpl(FORMAT + TURN + SEMICOLON + key);
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
		try {
			FileReader fr = new FileReader(IN);
			//br = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(fr);
			in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int t = Integer.valueOf(br.readLine());
		for (int i = 1; i <= t; i++) {
			//out.print("Case #" + i + ": ");
			solve(i);
		}
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new CountryLeader().run();
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