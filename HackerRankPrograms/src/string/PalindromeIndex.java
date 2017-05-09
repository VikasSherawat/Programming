package string;

import java.util.*;


public class PalindromeIndex {
public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);
     int T = in.nextInt();
     List<Integer> result = new ArrayList<Integer>();
     while(T-->0){
    	 String inp = in.next();
    	 result.add(findPalindromeIndex(inp));
     }
     for(Integer i: result){
    	 System.out.println(i);
     }
}
//baaa
private static Integer findPalindromeIndex(String inp) {
	// TODO Auto-generated method stub
	int len = inp.length();
	for(int i=0;i<len/2;i++){
		char pre=inp.charAt(i),post=inp.charAt(len-1-i);
		if(pre==post)
			continue;
		else if(inp.charAt(i)==inp.charAt(len-2-i) && inp.charAt(i+1)==inp.charAt(len-3-i) && inp.charAt(i+2)==inp.charAt(len-4-i))
			return len-1-i;
		else
			return i;
			
	}
	return -1;
}
}
