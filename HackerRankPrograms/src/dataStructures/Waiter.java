package dataStructures;

import java.io.*;
import java.io.ObjectInputStream.GetField;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Waiter {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int Q = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < T; i++) {
			list.add(in.nextInt());
		}
		
		List<Integer> primes = getFirstNPrime(Q);
		solve(primes, list);
	}
	private static void solve(List<Integer> primes, List<Integer> list) {
		// TODO Auto-generated method stub
		List<Stack<Integer>> ls = new ArrayList<Stack<Integer>>();
		for (int i = 0; i < primes.size(); i++) {
			int prime = primes.get(i);
			int index = list.size()-1;
			Stack<Integer> st = new Stack<Integer>();
			List<Integer> dlist = new ArrayList<Integer>();
			while(index>=0 && !list.isEmpty()){
				int c = list.get(index);
				if(c%prime==0){
					st.add(c);
					list.remove(index);
				}else{
					dlist.add(c);
				}
				index--;
			}
			list = dlist;
			ls.add(st);
		}
		
		for(Stack st: ls){
			while(!st.isEmpty()){
				System.out.println(st.pop());
			}
		}
		for (int i = list.size()-1; i >=0; i--) {
			System.out.println(list.get(i));
		}
	}
	public static List<Integer> getFirstNPrime(int n) {
		List<Integer> primeNumbers = new ArrayList<Integer>();
		primeNumbers.add(2);
		for (int i = 3; primeNumbers.size()!=n; i += 2) { // skip over even numbers since they
											// are not prime
			boolean isPrime = true;
			for (Integer prime : primeNumbers) { // check current prime numbers
													// to see if it evenly
													// divides into number
				if (i % prime == 0) { // when number is not prime
					isPrime = false;
					break; // optimization: stop checking when number is already
							// not prime
				}
			}
			if (isPrime) {
				primeNumbers.add(i);
			}
		}
		return primeNumbers;
	}
}
