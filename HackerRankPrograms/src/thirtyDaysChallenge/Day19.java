package thirtyDaysChallenge;

import java.io.*;
import java.util.*;

public class Day19 {

	 public static void main(String[] args) {
	        Scanner sc=new Scanner(System.in);
	        int n=sc.nextInt();
	        Calculator1 myCalculator=new Calculator1(); 
	        int sum=myCalculator.divisorSum(n);
	        System.out.println("I implemented: AdvancedArithmetic\n"+sum);
	    }
}
