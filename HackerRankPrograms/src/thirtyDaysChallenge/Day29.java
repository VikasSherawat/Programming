package thirtyDaysChallenge;

import java.util.*;
public class Day29 {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	String[] result = new String[T];
	int count =0;
	while(T-->0){
		result[count++]=findResult(in.next());
	}
	for(String str: result){
		System.out.println(str);
	}	
}

private static String findResult(String next) {
	// TODO Auto-generated method stub
	int len = next.length();
	for (int i = 1; i < len; i++) {
		int diff1 = next.charAt(i)-next.charAt(i-1);
		int diff2 = next.charAt(len-1-i)-next.charAt(len-i);
		if(Math.abs(diff1)!=Math.abs(diff2))
			return "Not Funny";
	}
	return "Funny";
}
}
