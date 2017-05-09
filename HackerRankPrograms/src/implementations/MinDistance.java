package implementations;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class MinDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[100000+1];
        int B[] = new int[100000+1];
        
        int min = Integer.MAX_VALUE;
        for(int A_i=0; A_i < n; A_i++){
            int a = in.nextInt();
            if(A[a]>=1){
            min = Math.min(min, Math.abs(B[a]-A_i));	
            }
            B[a] = A_i;
            A[a]++;
        }
        
        System.out.println(min==Integer.MAX_VALUE?-1:min);
	}

}
