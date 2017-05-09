package math;

import java.util.Arrays;
import java.util.TreeMap;

public class CombiningSlimes {
	public static void main(String[] args) {
		int[] a = {1,2,3};
		System.out.println(new CombiningSlimes().maxMascots(a));
	}

	public int maxMascots(int[] a) {
		int ans = 0;
		Arrays.sort(a);
		int c = 0, b = 0, p = 1;
		for (int i = a.length - 1; i > 0; i--) {
			if (i == a.length - 1)
				c = a[i];
			else
				c = p;
				
			b = a[i - 1];
			p = b+c;
			ans += b*c;
		}
		return ans;
	}
}
