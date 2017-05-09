package string;

public class GoodString {
	public static void main(String[] args) {
		String s = "aaaaaaaabbbaaabaaabbabababababaabbbbaabbabbbbbbabb";
		System.out.println(new GoodString().isGood(s));
	}
	
	public 	String isGood(String s){
		while(s.contains("ab")) 
			s = s.replaceAll("ab",""); 
			return s.equals("")?"Good":"Bad";
	}
}
