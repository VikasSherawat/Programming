package implementations;

import java.util.Scanner;

public class LibraryFine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        int AD = in.nextInt(),AM=in.nextInt(),AY=in.nextInt();
	        int ED = in.nextInt(),EM=in.nextInt(),EY=in.nextInt();
	        if(AY!=EY){
	        	if(AY<EY)
	        		System.out.println(0);
	        	else
	        	System.out.println(10000);
	        }else if(AM!=EM){
	        	if(AM>EM)
	        	System.out.println(500*Math.abs(AM-EM));
	        	else
	        		System.out.println(0);
	        }else if(AD!=ED && AD>ED)
	        	System.out.println(15*Math.abs(AD-ED));
	        else
	        	System.out.println(0);
	}

}
