package gametheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameOfStone {

	static int[] arr = new int[101];
	final static String SEC = "Second";
	final static String FIR = "First";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		List<String> list = new ArrayList<String>();
		Arrays.fill(arr, -1);
		solve();
		while (T-- > 0) {
			int N = in.nextInt();
			System.out.println(arr[N] % 2 == 0 ? SEC : FIR);
		}
		for (String inp : list)
			System.out.println(inp);
	}

	private static void solve() {
		// TODO Auto-generated method stub
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 1;
		arr[5] = 1;
		for (int i = 6; i < 101; i++) {
			if (arr[i - 2] == 0 || arr[i - 3] == 0 || arr[i - 5] == 0)
				arr[i] = 1;
			else
				arr[i] = 0;
		}
	}

}
