package implementations;

import java.util.Scanner;

public class NewYearChaos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int[] queueArray = new int[N];
			for (int i = 0; i < N; i++) {
				queueArray[i] = in.nextInt();
			}

			findMinBribes(queueArray);
		}

	}

	private static void findMinBribes(int[] queueArray) {
		// TODO Auto-generated method stub
		int[] count = new int[100001];
		int result = 0;
		int goTo =-1;
		for (int i = 0; i < queueArray.length-1; i++) {
			int index = i + 1;
			int value = queueArray[i];
			int nextValue = queueArray[i + 1];
			if (index == value) {
				goTo = index-1;
				continue;
			} else if (value > nextValue) {
				if (count[value] < 2) {
					count[value] += 1;
					swapItem(queueArray, i, i+1);
					result++;
					i = goTo;
					continue;
				} else {
					System.out.println("Too chaotic");
					return;
				}
			}

		}
		System.out.println(result);
	}

	private static void swapItem(int[] queueArray, int i, int j) {
		// TODO Auto-generated method stub
		int temp = queueArray[i];
		queueArray[i]=queueArray[j];
		queueArray[j] = temp;
		
	}
}
