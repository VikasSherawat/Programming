package bitManipulation;

import java.util.*;
public class LonelyInteger {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	int result = 0;
	for (int i = 0; i < N; i++) {
		result ^= in.nextInt();
	}
	
	System.out.println(result);
}
}
