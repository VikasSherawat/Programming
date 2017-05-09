package twopointer;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] a = { 1, 10, 20,101 };
		int[] b = { 3, 8, 10, 19 };
		new MergeSortedArray().merge(a, b);
	}

	public void merge(int[] a, int[] b) {
		int[] r = new int[a.length + b.length];
		int c = 0, d = 0;

		for (int i = 0; i < r.length; i++) {
			if (c < a.length && d < b.length) {
				if (a[c] <= b[d]) {
					r[i] = a[c++];
				} else {
					r[i] = b[d++];
				}
			} else {
				if (c >= a.length) {
					r[i] = b[d++];
				} else {
					r[i] = a[c++];
				}
			}
		}
		
		for(int i : r)
			System.out.print(i+" ");
	}
}
