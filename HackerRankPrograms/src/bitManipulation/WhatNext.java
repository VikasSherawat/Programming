package bitManipulation;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class WhatNext {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			BigInteger[] arr = new BigInteger[N];
			for (int i = 0; i < N; i++) {
				arr[i] = in.nextBigInteger();
			}
			solve(arr);
		}
	}

	private static void solve(BigInteger[] arr) {
		// TODO Auto-generated method stub
		if (arr.length == 1) {
			if (arr[0].compareTo(BigInteger.ONE) == 0) {
				System.out.println(2);
				System.out.println("1 0");
			} else {
				System.out.println(3);
				System.out.println("1 0 " + arr[0].subtract(BigInteger.ONE));
			}
		} else if (arr.length == 2) {
			if (arr[0].compareTo(BigInteger.ONE) == 0) {
				System.out.println(2);
				System.out.println("1 " + arr[1].add(BigInteger.ONE));
			} else {
				System.out.println(3);
				System.out.println("1 " + arr[1].add(BigInteger.ONE) + " "
						+ arr[0].subtract(BigInteger.ONE));
			}
		} else {
			if (arr.length % 2 == 1) {
				// for odd length
				if (arr[arr.length - 2].compareTo(BigInteger.ONE) == 0) {
					if (arr[arr.length - 1].compareTo(BigInteger.ONE) == 1) {
						System.out.println((arr.length - 1));
						arr[arr.length - 3] = arr[arr.length - 3]
								.add(BigInteger.ONE);
						for (int i = 0; i < arr.length - 1; i++) {
							System.out.print(arr[i] + " ");
						}
						System.out.println();

					} else {
						System.out.println(arr.length);
						arr[arr.length - 3] = arr[arr.length - 3]
								.add(BigInteger.ONE);
						arr[arr.length - 1] = arr[arr.length - 1]
								.subtract(BigInteger.ONE);
						for (int i = 0; i < arr.length; i++) {
							System.out.print(arr[i] + " ");
						}
						System.out.println();
					}
				} else {
					if (arr[arr.length - 1].compareTo(BigInteger.ONE) == 1) {
						//when  secondLast is not one Last value is one
						arr[arr.length-2] = arr[arr.length-2].subtract(BigInteger.ONE);
						for (int i = 0; i < arr.length; i++) {
							System.out.print(arr[i]+" ");
						}
						System.out.println("1");
						
					} else {
						System.out.println(arr.length + 2);
						arr[arr.length - 2] = arr[arr.length - 2]
								.subtract(BigInteger.ONE);
						arr[arr.length - 1] = arr[arr.length - 1]
								.subtract(BigInteger.ONE);
						for (int i = 0; i < arr.length - 1; i++) {
							System.out.print(arr[i]+" ");
						}
						System.out.println("1 1 "+arr[arr.length-1]);
					}
				}
			} else {
				// for even length
			}
		}
	}
}
