package simpleSearch;

public class MoveStonesEasy {
	public static void main(String[] args) {
		int[] a = { 10, 5, 13, 1 };
		int[] b = { 20, 7, 2, 0 };
		System.out.println(new MoveStonesEasy().get(a, b));
	}

	public int get(int[] a, int[] b) {
		int n = a.length;
	    int p = 0;
	    int cost = 0;
	    for (int i = 0; i < n; i++) {
	        int has, needs;
	        if (p >= 0) {
	            has = a[i] + p;
	            needs = b[i];
	        } else {
	            has = a[i];
	            needs = b[i] - p;
	        }
	        p = has - needs;
	        cost += Math.abs(p);
	    }
	     
	    return (p == 0) ? cost : -1;
	}
}