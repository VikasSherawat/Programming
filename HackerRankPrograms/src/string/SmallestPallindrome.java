package string;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SmallestPallindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner in;
		try {
			in = new Scanner(new File("C:\\Users\\Vikas Kumar\\Desktop\\pal.txt"));
			String s = shortestPalindrome(in.nextLine());
			
			PrintWriter pw = new PrintWriter(new File("C:\\Users\\Vikas Kumar\\Desktop\\pal-o.txt"));
			pw.write(s);
			pw.flush();
			pw.close();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

	public static String shortestPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (i = s.length(); i > 0; i--) {
			if(isPallindrome(s.substring(0, i))){
				break;
			}
		}
		
		sb.append(s.substring(i));
		 sb.reverse();
		  sb.append(s);
		
		return sb.toString();
	}



	private static boolean isPallindrome(String s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < s.length()/2; i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}
}