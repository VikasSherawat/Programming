package visa.second;

import java.util.Arrays;
import java.util.TreeMap;

public class B {
	public static void main(String[] args) {
		int[] a = { 2,3,4};
		System.out.println(countMoves(a));
	}

	static long countMoves(int[] numbers) {
		long ans = 0L;
		Arrays.sort(numbers);
		long min = numbers[0];
		for (int i = numbers.length - 1; i >= 0; i--) {
			ans += numbers[i] - min;
		}
		return ans;
	}
}
