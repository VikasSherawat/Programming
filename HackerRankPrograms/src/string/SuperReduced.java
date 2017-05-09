package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SuperReduced {
	public void run() {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		try {
			String inp = bi.readLine();
			String result = solve(inp);
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String solve(String inp) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<Character>();
		stack.push(inp.charAt(0));
		for (int i = 1; i < inp.length(); i++) {
			char c = inp.charAt(i);
			

			if (stack.size()>0 && c == stack.peek()) {
				stack.pop();
			} else {
				stack.add(c);
			}

		}
		if (stack.size() == 0)
			return "Empty String";
		else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
			
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		new SuperReduced().run();
	}
}
