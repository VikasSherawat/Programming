package set3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Jumbled {
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
	TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
	
	private void solve() throws Exception {
		for (int i = 0; i < 128; i++) {
			int x = i^(i<<1);
			map.put(x, i);
		}
		
		for(int i = 128;i<256;i++){
			String s = Integer.toBinaryString(i);
			int j=0;
			j = Integer.valueOf(s.substring(1)+"0",2);
			int ans = i^j;
			map.put(ans, i);
		}
		/*System.out.println("Map.size:--"+map.size());
		for (Map.Entry<Integer, Integer> m : map.entrySet())
		{
			System.out.println(m.getKey()+":"+m.getValue());
		}*/
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
			// FileReader fr = new FileReader(IN);
			br = new BufferedReader(new InputStreamReader(System.in));
			// br = new BufferedReader(fr);
			// in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int t = Integer.valueOf(br.readLine());
		int[] arr = sarr2IntArr(br.readLine().split("\\s+"));
		solve();
		for (int j = 0; j < arr.length; j++) {
			System.out.print(map.get(arr[j])+" ");
		}
		//in.close();
		//out.close();
	}

	public static void main(String args[]) throws Exception {
		new Jumbled().run();
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
		int[] a = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = s2int(arr[i]);
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
