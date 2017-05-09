package weekofcode19;

import java.util.*;
public class FixCycle {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int a = in.nextInt(),b= in.nextInt(),c= in.nextInt(),d= in.nextInt(),e= in.nextInt(),f= in.nextInt();
	int result =  findMinNumber(a,b,c,d,e,f);
	System.out.println(result);
}

private static int findMinNumber(int a, int b, int c, int d, int e, int f) {
	// TODO Auto-generated method stub
	int cycle1=a+e+d;
	int cycle2=a+b+f;
	int cycle3=a+b+c+d;
	if(cycle1<0 && cycle1<=cycle2){
		if(cycle1<=cycle3)
			return Math.abs(cycle1);
		else
			return Math.abs(cycle3);
	}else if(cycle2<0 && cycle2<=cycle3){
			return Math.abs(cycle2);
	}else if(cycle3<0){
		return Math.abs(cycle3);
	}else
	return -1;
}
}
