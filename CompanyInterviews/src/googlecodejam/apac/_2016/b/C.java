package googlecodejam.apac._2016.b;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class C {
	static final String FILENAME = "attempt0";
	static final String QUESTION = "C-";
	static final String SIZE = "large";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE  + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME
			+ "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;

	private void solve(int TURN) {
		int ans = 0;
		int N = in.nextInt();
		String[] arr = new String[N];
		
		for(int i =0;i<N;i++){
			arr[i] = in.next();
		}
		Set<Fun> set = new HashSet<Fun>();
		Map<String,Fun> map = new TreeMap<String,Fun>();
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			Fun f = new Fun();
			String[] fn = s.split("=");
			f.result = fn[0];
			String arguments = fn[1].substring(fn[1].
					indexOf("(")+1, fn[1].indexOf(")"));
			if(fn[1].indexOf(")")-fn[1].indexOf("(")==1){
				map.put(fn[0], f);
				continue;
			}
			
			if(arguments.contains(",")){
				f.parameters = arguments.split(",");
				f.nArgum = f.parameters.length;
			}else{
				f.nArgum = 1;
				f.parameters = new String[1];
				f.parameters[0] = arguments;
			}
			//set.add(f);
			map.put(fn[0], f);
			
		}
		if(check(map))
			fpl(FORMAT + TURN + SEMICOLON + "GOOD");
		else
			fpl(FORMAT + TURN + SEMICOLON + "BAD");
	}
	
	private boolean check(Map<String, Fun> map) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		Map<String,Fun> dMap = new TreeMap<String, C.Fun>(map);
		int j=0;
		while(j++<10000 && dMap.size()>0){
			for(Map.Entry<String,Fun> m: map.entrySet()){
				String key = m.getKey();
				Fun value = m.getValue();
				if(value.nArgum==0){
					set.add(value.result);
					dMap.remove(key);
				}
				else{
					boolean flag = true;
					for(int i =0;i<value.nArgum;i++){
						if(!set.contains(value.parameters[i])){
							flag = false;
							break;
						}
					}
					if(flag){
						set.add(value.result);
						dMap.remove(key);
					}
				}
			}
		}
		if(dMap.size()!=0)
			return false;
		else
			return true;
	}

	class Fun implements Comparable<Fun>{
		int nArgum;
		String result;
		String[] parameters;

		@Override
		public int compareTo(Fun fu) {
			// TODO Auto-generated method stub
			int f = fu.nArgum;
			if(f<nArgum)
				return -1;
			else if(f>nArgum)
				return 1;
			else
			return 0;
		}
		
		
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
		new C().run();
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
