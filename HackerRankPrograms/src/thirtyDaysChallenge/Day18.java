package thirtyDaysChallenge;
import java.util.*;

import javax.management.Query;
class Palindrome{
	int count=0;
	ArrayList<Character> list =  new ArrayList<Character>();
	ArrayList<Character> queue =  new ArrayList<Character>();
	public void pushCharacter(char c) {
		// TODO Auto-generated method stub
		list.add(c);
		
	}

	public void enqueueCharacter(char c) {
		// TODO Auto-generated method stub
		queue.add(c);
		
	}

	public char popCharacter() {
		// TODO Auto-generated method stub
		char pop ='0';
		if(list.size()>0){
			pop= list.get(list.size()-1);
			list.remove(list.size()-1);
		}
		return pop;
	}

	public char dequeueCharacter() {
		// TODO Auto-generated method stub
		char deq='0';
		if(queue.size()>0)
			deq = queue.get(0);
		queue.remove(0);
		return deq;
	}
	
}

public class Day18 {
	 public static void main(String[] args) {
	        Scanner sc=new Scanner(System.in);
	        // read the string s.
	        String s = sc.nextLine();
	        
	        // create the Palindrome class object p.
	        Palindrome p = new Palindrome();
	        char arr[]=s.toCharArray();//Converting string to a character array
	        // push all the characters of string s to stack.
	        for (char c : arr) {
	            p.pushCharacter(c);
	        }
	        
	        // enqueue all the characters of string s to queue.
	        for (char c : arr) {
	            p.enqueueCharacter(c);
	        }
	        
	        boolean f = true;
	        
	        // pop the top character from stack.
	        // dequeue the first character from queue.
	        // compare both the characters.
	        for (int i = 0; i < s.length(); i++) {
	            if (p.popCharacter() != p.dequeueCharacter()) {
	                f = false;                
	                break;
	            }
	        }
	        
	        // finally print whether string s is palindrome or not.
	        if (f) {
	            System.out.println("The word, "+s+", is a palindrome.");
	        } else {
	            System.out.println("The word, "+s+", is not a palindrome.");
	        }
	    }
}
