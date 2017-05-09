package hired;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static void main(String[] args) {
	//	Scanner in = new Scanner(System.in);
		String s = "dadf";
		System.out.println(new Solution().solution(s));

	}

	public int solution(String S) {
		String[] text = S.split("[.!?]");
		List<String> textList = Arrays.asList(text);
		int max = 0;
		for(String eachSentence : textList){
			eachSentence = eachSentence.trim();
			List<String> sentence = Arrays.asList(eachSentence.split("\\s+"));
			int count =0;
			for(String s: sentence){
				if(s.length()>0)
					count++;
			}
			max = count > max ? count : max; 
		}
		return max;
	}

}