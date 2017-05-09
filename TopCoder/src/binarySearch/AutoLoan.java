package binarySearch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AutoLoan {
	public static void main(String[] args) {
		double price = 6800d;
		double month = 100d;
		int loanTerm = 68;
		double d = new AutoLoan().interestRate(price, month, loanTerm);
		System.out.println(d);
	}

	public double interestRate(double price, double M, int loanTerm) {
		// TODO Auto-generated method stub
		//P = M(1-[1+(i/q)]-nq)q/i.
		
		double lo = 0.0d, hi = 100d;
		double q = 12d;
		double n = loanTerm/q;
		double I = 0.0d;
		while(hi-lo>1e-12){
			I = lo + (hi - lo) / 2;
			double a = q/(q+I);
			double P = M*(1-Math.pow(a, n*q))*q/I;
			if(Math.abs(P-price)>1e-12){
				hi = I;
			}else{
				lo = I;
			}
			
		}
		
		return I*100;
	}
}
