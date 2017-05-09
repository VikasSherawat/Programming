package binarySearch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HairCuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] enter = {"09:00","09:22","09:22"};
		String lastExit = "10:11";
		double d = new HairCuts().maxCut(enter, lastExit);
		double ans = 23.666666666666863d;
		System.out.println(d+":"+(ans-d));
	}

	public double maxCut(String[] enter, String lastExit) {
		// TODO Auto-generated method stub
		double[] arr = getTime(enter);
		double last = convertTime(lastExit);
		double hi = last - arr[arr.length - 1];
		double lo = 5d;
		double total = last;
		if (!checkValid(arr, hi, total,last)) {
			return -1;
		}
		int count = 0;
		while (hi - lo > 1e-10) {
			count++;
			double m = lo + (hi - lo) / 2;
			double hype = 0d;
			for (int i = 0; i < arr.length; i++) {
					if(arr[i]>hype)
						hype = arr[i]+m;
					else{
						hype += m;
					}
				if (hype > total) {
					break;
				}
			}


			if (Math.abs(hype - total) < 1e-9) {
				return m;
			}
			if (hype > total) {
				hi = m;
			} else {
				lo = m;
			}

		}
		
		return lo;
	}

	private boolean checkValid(double[] arr, double hi, double total,double last) {
		// TODO Auto-generated method stub
		double time = 0d, free = 0d;
		for (int i = 0; i < arr.length; i++) {
			time += 5;
			free = arr[i]+5;
			if (time > total)
				return false;
			if(i!=arr.length-1 && free+5>last){
				return false;
			}
			

		}
		
		return true;
	}

	private int convertTime(String lastExit) {
		// TODO Auto-generated method stub
		String[] time = lastExit.split(":");
		int hour = Integer.valueOf(time[0]);
		int min = Integer.valueOf(time[1]);
		int tMin = 0;
		if (hour < 9) {
			hour += 12;
		}

		tMin += 60 * (hour - 9) + min;
		return tMin;
	}

	private double[] getTime(String[] enter) {
		// TODO Auto-generated method stub
		double[] arr = new double[enter.length];
		for (int i = 0; i < arr.length; i++) {
			String[] time = enter[i].split(":");
			int hour = Integer.valueOf(time[0]);
			int min = Integer.valueOf(time[1]);
			int tMin = 0;
			if (hour < 9) {
				hour += 12;
			}

			tMin += 60 * (hour - 9) + min;
			arr[i] = tMin;
		}
		Arrays.sort(arr);
		return arr;
	}

}
