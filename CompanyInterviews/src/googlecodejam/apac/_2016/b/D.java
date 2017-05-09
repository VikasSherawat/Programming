package googlecodejam.apac._2016.b;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class D {
	static final String FILENAME = "attempt0";
	static final String QUESTION = "D-";
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
		List<Sol> set = new ArrayList<Sol>();
		List<Sol1> rset = new ArrayList<Sol1>();
		
		for (int i = 1; i <=N ; i++) {
			int at = in.nextInt();
			int df = in.nextInt();
			Sol sol = new Sol(i,at,df);
			set.add(sol);
			Sol1 sol1 = new Sol1(i,at,df);
			rset.add(sol1);
		}
		Collections.sort(set);
		Collections.sort(rset);
		
		Sol first = set.get(0);
		Sol second = set.get(1);
		
		int fI=0, sI=0;
		
		for(int i =0;i<rset.size();i++){
			if(rset.get(i).id== first.id)
				fI = i;
			if(rset.get(i).id == second.id)
				sI = i;
			
			if(fI!=0 && sI!=0)
				break;
		}
		
		boolean flag = false;
		
		if(fI==0){
			flag = true;
		}else if(fI>1)
			flag = true;
		
		if(sI<=fI || fI==0)
			fpl(FORMAT + TURN + SEMICOLON + "YES");
		else
			fpl(FORMAT + TURN + SEMICOLON + "NO");
	}
	
	class Sol implements Comparable<Sol>{
		
		int id;
		int at;
		int df;
		
		 public Sol(int id,int at,int df){
			this.id = id;
			this.at = at;
			this.df = df;
		}
		@Override
		public int compareTo(Sol o) {
			// TODO Auto-generated method stub
			if(o.at>this.at)
				return 1;
			else if(o.at<this.at)
				return -1;
			else{
				if(o.df>this.df)
					return 1;
				else if(o.df<this.df)
					return -1;
			}
			return 0;
		}
		
	}
	
	class Sol1 implements Comparable<Sol1>{
		int id;
		int at;
		int df;
		
		public Sol1(int id,int at,int df){
			this.id = id;
			this.at = at;
			this.df = df;
		}
		@Override
		public int compareTo(Sol1 o) {
			// TODO Auto-generated method stub
			if(o.df>this.df)
				return 1;
			else if(o.df<this.df)
				return -1;
			else{
				if(o.at>this.at)
					return 1;
				else if(o.at<this.at)
					return -1;
			}
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
			//out.print("Case #" + i + ": ");
			solve(i);
		}
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new D().run();
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
