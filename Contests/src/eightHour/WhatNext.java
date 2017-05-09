package eightHour;

import java.util.Scanner;

public class WhatNext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long[] arr;
		while (T-- > 0) {
			int n = in.nextInt();
			arr = new long[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = in.nextLong();
			}
			solve(arr, n);
			System.out.println();
		}
	}

	private static void solve(long[] arr, int len) {
		// TODO Auto-generated method stub

		if (len < 4) {
			smallArray(arr, len);
			return;
		}

		if (len % 2 == 0) {
			if (arr[len - 3] == 1 && arr[len - 2] == 1) {
				System.out.println(len - 2);
				for (int i = 0; i < len - 4; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.print(arr[len - 4] + 1 + " ");
				System.out.print((arr[len - 3] + arr[len - 1]));
			} else if (arr[len - 3] == 1 && arr[len - 2] != 1) {
				System.out.println(len - 1);
				for (int i = 0; i < len - 4; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.print(arr[len - 4] + 1 + " ");
				System.out.print((arr[len - 3] + arr[len - 1]) + " ");
				System.out.print(arr[len - 2] - 1);
			} else if (arr[len - 2] == 1) {
				System.out.println(len);
				for (int i = 0; i < len - 3; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.print(arr[len - 3] - 1 + " 1 ");
				System.out.print(arr[len - 1] + 1);
			} else {
				System.out.println(len + 1);
				for (int i = 0; i < len - 3; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.print(arr[len - 3] - 1 + " 1 ");
				System.out.print(arr[len - 1] + 1 + " ");
				System.out.print(arr[len - 2] - 1);
			}

		} else {
			if (arr[len - 2] == 1 && arr[len - 1] != 1) {
				System.out.println(len);
				arr[len - 3] = arr[len - 3] + 1;
				if(arr[len-1]!=1)
					arr[len - 1] = arr[len - 1] - 1;
				else
					arr[len-1] = 1;
				for (int i = 0; i < len; i++) {
					System.out.print(arr[i] + " ");
				}

			} else if (arr[len - 2] == 1 && arr[len - 1] == 1) {
				System.out.println(len-1);
				for (int i = 0; i < len-3; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.print(arr[len-3]+1 + " " + 1);
			

			}else if (arr[len - 2] != 1 && arr[len - 1] == 1) {
				System.out.println(len + 1);
				for (int i = 0; i < len - 2; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.print(arr[len - 2] - 1 + " 1 1 ");
			} else {
				System.out.println(len + 2);
				for (int i = 0; i < len - 2; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.print(arr[len - 2] - 1 + " 1 1 ");
				System.out.print(arr[len - 1] - 1);
			}

		}
	}

	private static void smallArray(long[] arr, int len) {
		// TODO Auto-generated method stub
		switch (len) {
		case 1:
			if (arr[0] == 1) {
				System.out.println(2);
				System.out.print("1 1");
			} else {
				System.out.println(3);
				System.out.print("1 1 " + (arr[0] - 1));
			}
			break;
		case 2:
			if (arr[0] == 1) {
				System.out.println(2);
				System.out.print(1 + " " + (arr[1] + 1));
			} else {
				System.out.println(3);
				System.out.print(1 + " " + (arr[1] + 1) + " " + (arr[0] - 1));
			}
			break;
		default:
			if (arr[2] == 1 && arr[1] == 1) {
				System.out.println(2);
				System.out.print(arr[0] + 1 + " " + "1");
			} else if (arr[2] == 1 && arr[1] != 1) {
				System.out.println(4);
				System.out.print(arr[0] + " " + (arr[1] - 1) + " 1 1");
			} else if (arr[2] != 1 && arr[1] != 1) {
				System.out.println(5);
				System.out.print(arr[0] + " " + (arr[1] - 1) + " 1 1 "
						+ (arr[2] - 1));
			} else {
				System.out.println(3);
				System.out.print(arr[0] + 1 + " 1 " + (arr[2] - 1));
			}
			break;
		}
	}

}
