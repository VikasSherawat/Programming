package math;

import java.util.*;

public class IsItASquare {

	public String isSquare(int[] x, int[] y) {
		String a = "It's a square", b = "Not a square";
		double p = d(x[0], y[0], x[1], y[1]);
		double q = d(x[0], y[0], x[2], y[2]);
		double da = d(x[0], y[0], x[3], y[3]);
		double db = d(x[3], y[3], x[1], y[1]);
		double r = d(x[1], y[1], x[2], y[2]);
		double s = d(x[3], y[3], x[2], y[2]);
		boolean flag = true;
		Set<Double> set = new HashSet<>();
		set.add(p);
		set.add(q);
		set.add(r);
		set.add(s);
		set.add(da);
		set.add(db);
		if(set.size()!=2)
			flag  = false;
		
		return flag?a:b;
	}

	private double d(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		double d = Math.sqrt(Math.pow(k - i, 2) + Math.pow(l - j, 2));
		return d;
	}

	public static void main(String[] args) {
		int[] x = {0, 5000, 5000, 10000};
		int[] y = {5000, 0, 10000, 5000};

    	



		
		System.out.println(new IsItASquare().isSquare(x, y));
	}
}
