package visa;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.security.auth.callback.ChoiceCallback;

public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] arr = { "127.0.0.1a", "Random Test is this", "2001:0gb8:85a3:0000:0000:8a2e:0370:7334" };
		String[] ans = new B().checkIP(arr);
		for (String s : ans) {
			System.out.println(s);
		}

	}

	public String[] checkIP(String[] arr) {
		String[] ans = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ans[i] = validIP(arr[i]);
		}
		return ans;
	}

	private String validIP(String s) {
		// TODO Auto-generated method stub
		String neither = "Neither";
		if (s.indexOf(".") != -1) {
			return checkIPv4(s);
		} else if (s.indexOf(":") != -1) {
			return checkIPv6(s);
		} else {
			return "Neither";
		}

	}

	private String checkIPv6(String s) {
		// TODO Auto-generated method stub
		String[] arr = s.split(":");
		if (arr.length != 8) {
			return "Neither";
		}
		for (int i = 0; i < arr.length; i++) {
			String grp = arr[i];
			for (int j = 0; j < grp.length(); j++) {
				char c = grp.charAt(j);
				if (Character.isDigit(c)) {
					continue;
				}

				if (c == 'a' || c == 'A') {
					continue;
				} else if (c == 'b' || c == 'B') {
					continue;
				} else if (c == 'c' || c == 'C') {
					continue;
				} else if (c == 'd' || c == 'D') {
					continue;
				} else if (c == 'e' || c == 'E') {
					continue;
				} else if (c == 'f' || c == 'F') {
					continue;
				} else {
					return "Neither";
				}
			}
		}
		return "IPv6";
	}

	private String checkIPv4(String s) {
		// TODO Auto-generated method stub
		String[] arr = s.split("\\.");
		if (arr.length != 4) {
			return "Neither";
		}
		for (int i = 0; i < arr.length; i++) {
			String ele = arr[i];
			try {
				int val = Integer.valueOf(ele);
				if (!(val >= 0 && val < 256)) {
					return "Neither";
				}
			} catch (Exception e) {
				return "Neither";
			}

		}
		return "IPv4";
	}
}
