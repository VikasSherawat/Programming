package googlecodejam.sixteen;

import java.io.*;
import java.util.*;

public class Technobabble {
	static final String FILENAME = "practice";
	static final String QUESTION = "C-";
	static final String SIZE = "small-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME + "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;

	private void solve(int TURN) {
		int ans = 0;
		int N = in.nextInt();
		String[] first = new String[N];
		String[] second = new String[N];
		Set<String> fSet = new HashSet<String>();
		Set<String> sSet = new HashSet<String>();
		
		for (int i = 0; i < N; i++) {
			first[i] = in.next();
			second[i] = in.next();
			fSet.add(first[i]);
			sSet.add(second[i]);
		}
		boolean[] unique1 = new boolean[N];
		boolean[] unique2 = new boolean[N];
		
		fillUnique(unique1,unique2,first,second);
		System.out.println("Unique words in first:"+fSet.size());
		System.out.println("Unique words in second:"+sSet.size());
		
		for (int i = 0; i < unique2.length; i++) {
			if(unique1[i] && unique2[i]){
				continue;
				/*int moveFirst = canMove(first,i);
				int moveSecond = canMove(second,i);
				if( moveFirst> i&&  moveSecond>i){
					if((moveFirst == moveSecond) || (!unique2[moveFirst] && !unique1[moveSecond])
							|| (unique2[moveFirst] && unique1[moveSecond])){
						unique1[moveFirst] = true;
						unique2[moveSecond] = true;
						unique1[i] = unique2[i] = false;
					}
				}*/
			}else if(unique1[i] && !unique2[i]){
				int moveFirst = canMove(first,i);
				if(moveFirst > i){
					unique1[moveFirst] = true;
					unique1[i] = false;
				}
			}else if(!unique1[i] && unique2[i]){
				int moveSecond = canMove(second,i);
				if(moveSecond > i){
					unique2[moveSecond] = true;
					unique2[i] = false;
				}
			}else{
				continue;
			}
		}
		
		for (int i = 0; i < unique2.length; i++) {
			if(unique1[i] || unique2[i])
				ans++;
		}
		
		pl(FORMAT + TURN + SEMICOLON + (N-ans));
	}

	private int canMove(String[] first, int i) {
		// TODO Auto-generated method stub
		for (int j = i+1; j < first.length; j++) {
			if(first[i].equalsIgnoreCase(first[j]))
				return j;
		}
		return -1;
	}

	private void fillUnique(boolean[] unique1, boolean[] unique2,
			String[] first, String[] second) {
		// TODO Auto-generated method stub
		for (int i = 0; i < first.length; i++) {
			if(wordExists(first[i], first, i)){
				unique1[i] = true;
			}
			
			if(wordExists(second[i], second, i)){
				unique2[i] = true;
			}
		}
		
	}

	private boolean wordExists(String string, String[] first, int i) {
		// TODO Auto-generated method stub
		for (int j = 0; j < i; j++) {
			if (first[j].equalsIgnoreCase(string)) {
				if(j!=i)
					return false;
				else
					return true;
			}
		}
		return true;
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
			// out.print("Case #" + i + ": ");
			solve(i);
		}
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new Technobabble().run();
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
