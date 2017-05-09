package greedy;
import java.util.*;

public class ChiefHopper {

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	double[] ar = new double[N];
	for (int i = 0; i < N; i++) {
		ar[i]=in.nextDouble();
	}
	if(N==1)
		System.out.println((int)Math.ceil((ar[0]+0)/2));
	else
	solve(ar);
}

private static void solve(double[] ar) {
	// TODO Auto-generated method stub
	int N = ar.length;
	double temp=0;
	for (int i = N-1; i >=0; i--) {
		 temp = Math.ceil((ar[i]+temp)/2);
		//System.out.println(temp);
	}
	System.out.println((int)temp);
}
}
