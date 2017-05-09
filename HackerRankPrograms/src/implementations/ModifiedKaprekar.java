package implementations;

import java.math.BigInteger;
import java.util.Scanner;

public class ModifiedKaprekar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      Scanner in = new Scanner(System.in);
	        int A = in.nextInt();
	        int B = in.nextInt();
	        boolean flag = true;
	        for (long i = A; i <= B; i++) {
				BigInteger sqr = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i));
				
				long pow = 0;
				if(i<10)
					pow=10;
					else if(i>9 && i<=99)
						pow = 100;
					else if(i>99 && i<=999)
						pow = 1000;
					else if(i>999 && i<=9999)
						pow = 10000;
					else
						pow = 100000;
				BigInteger div = sqr.divide(BigInteger.valueOf(pow));
				BigInteger rem = sqr.remainder(BigInteger.valueOf(pow));
				
				/*System.out.println("Square of the number"+i+" is--"+sqr);
				System.out.println("Power of the number is--"+pow);
				System.out.println("div of the number is--"+div);
				System.out.println("Rem of the number is--"+rem);
				System.out.println("Sum of Div and Rem is--"+div.add(rem));*/
				if(div.add(rem).compareTo(BigInteger.valueOf(i))==0){
					System.out.println(i+" ");
					flag=false;
				}
			}
	        if(flag)
	        	System.out.println("INVALID RANGE");
	        
	}

}
