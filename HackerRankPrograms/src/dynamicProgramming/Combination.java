package dynamicProgramming;

import java.util.*;
public class Combination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inp = "1234";
		ArrayList<String> list = makeCombinations(inp);
	}

	private static ArrayList<String> makeCombinations(String inp) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		int len = inp.length();
		Map<Integer,ArrayList<String>> map = new TreeMap<Integer, ArrayList<String>>();
		for (int i = 0; i < len; i++) {
			String temp="";
			String prefix = inp.substring(i, i+1);
			for (int j = 0; j < len; j++) {
				
			}
		}
		return null;
	}

}
