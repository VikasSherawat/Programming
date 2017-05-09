package set3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EqualSum {
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

	private void solve(int TURN) throws Exception {
		int ans = 0;
		int[] arr = sarr2IntArr(br.readLine().split("\\s+"));
		int l = (int)Math.pow(2,20)-1;
		pl(FORMAT + TURN + SEMICOLON);
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i <=l; i++) {
			String s = String.format("%20s", Integer.toBinaryString(i)).replace(' ', '0');
			int sum = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j =0;j<s.length();j++){
				if(s.charAt(j)=='1'){
					sum+=arr[j];
					list.add(arr[j]);
				}
			}
			if(map.containsKey(sum)){
				if(map.get(sum).size()!=list.size()){
					List<Integer> ls = map.get(sum);
					for(int x:ls){
						System.out.print(x+" ");
					}
					System.out.println();
					for(int x: list){
						System.out.print(x+" ");
					}
					System.out.println();
					return;
				}
			}else{
				map.put(sum, list);
			}
				
		}
		System.out.println("Impossible");
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
			//FileReader fr = new FileReader(IN);
			br = new BufferedReader(new InputStreamReader(System.in));
			//br = new BufferedReader(fr);
			//in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		//configOutput();
		int t = Integer.valueOf(br.readLine());
		for (int i = 1; i <= t; i++) {
			//out.print("Case #" + i + ": ");
			solve(i);
		}
		//in.close();
		//out.close();
	}

	public static void main(String args[]) throws Exception {
		new EqualSum().run();
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

	public int s2int(String v) {
		return Integer.valueOf(v);
	}

	public int[] sarr2IntArr(String[] arr) {
		int[] a = new int[20];
		for (int i = 0; i < a.length; i++) {
			a[i] = s2int(arr[i+1]);
		}

		return a;
	}

	public long[] sarr2LongArr(String[] arr) {
		long[] a = new long[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = s2long(arr[i]);
		}

		return a;
	}

	public long s2long(String v) {
		return Long.valueOf(v);
	}
}