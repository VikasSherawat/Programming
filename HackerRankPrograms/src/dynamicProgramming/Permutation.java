package dynamicProgramming;

import java.util.*;

public class Permutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inp = "ABC";
		System.out.println(findPermutation(inp));
	}

	private static Set<String> findPermutation(String inp) {
		// TODO Auto-generated method stub
		Set<String> output = new HashSet<String>();
		if(inp==null)
			return null;
		else if(inp.length()==0){
			output.add("");
			return output;
		}else{
			char prefix = inp.charAt(0);
			String suffix = inp.substring(1);
			Set<String> result = findPermutation(suffix);
			for (String str: result) {
				for (int i = 0; i <= str.length(); i++) {
					output.add(arrangeLetters(prefix,str,i));
				}
			}
		}
		
		return output;
	}

	private static String arrangeLetters(char prefix, String str, int i) {
		// TODO Auto-generated method stub
		String pre = str.substring(0, i);
		String last = str.substring(i);
		return pre+prefix+last;
	}

}
