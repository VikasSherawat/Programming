package regex;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IPMatcher {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String p = "[[1-9](A|B|C|D|E|F)]+[[0-9]*(A|B|C|D|E|F)]*";
		if(s.matches(p)){
			System.out.println("YES");
		}else
			System.out.println("NO");
		
		
	}
	
	public void ip4Validater(String s){
		String _4 = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		String _6 = "";
		Pattern p = Pattern.compile(_4);
		Matcher m = p.matcher(s);
		if(m.find()){
			System.out.println(m.group(1));
			System.out.println(m.group(2));
			System.out.println(m.group(3));
			System.out.println(m.group(4));
		}else{
			System.out.println("Wrong Pattern");
		}
	}
	
	public boolean emailValidated(String s){
		//sak@gmail.com
		String email = "^\\w+@{1}\\w+(\\.\\w+){1,}$";
		//String email ="";
		Pattern p = Pattern.compile(email);
		Matcher m = p.matcher(email);
		if(s.matches(email)){
			return true;
		}
		return false;
	}
	
	
}
