package thirtyDaysChallenge;

import java.util.*;



public class Day20 {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String inp = in.nextLine();
	StringTokenizer st = new StringTokenizer(inp.replaceAll("[!|\\[|,|\\?|.|\\\\|_|'|@|\\+|\\]]"," ")); 
	System.out.println(st.countTokens());
	while(st.hasMoreElements()){
		System.out.println(st.nextToken());
		}
	}
}
