package googlecodejam.sixteen;

/*
 * Problem

Bleatrix Trotter the sheep has devised a strategy that helps her fall asleep faster. First, she picks a number N. Then she starts naming N, 2 × N, 3 × N, and so on. Whenever she names a number, she thinks about all of the digits in that number. She keeps track of which digits (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) she has seen at least once so far as part of any number she has named. Once she has seen each of the ten digits at least once, she will fall asleep.

Bleatrix must start with N and must always name (i + 1) × N directly after i × N. For example, suppose that Bleatrix picks N = 1692. She would count as follows:

N = 1692. Now she has seen the digits 1, 2, 6, and 9.
2N = 3384. Now she has seen the digits 1, 2, 3, 4, 6, 8, and 9.
3N = 5076. Now she has seen all ten digits, and falls asleep.
What is the last number that she will name before falling asleep? If she will count forever, print INSOMNIA instead.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with a single integer N, the number Bleatrix has chosen.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the last number that Bleatrix will name before falling asleep, according to the rules described in the statement.
 */

import java.util.*;

public class sheep {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] result = new int[T];
		int count =0;
		while(T-->0){
			int N = in.nextInt();
			result[count++] = countSheep(N);
		}
		for(int i = 0; i<result.length; i++){
			if(result[i]!=-1){
				System.out.println("Case #"+(i+1)+": "+result[i]);
			}else{
				System.out.println("Case #"+(i+1)+": INSOMNIA");
			}
		}
	}

	private static Integer countSheep(int n) {
		// TODO Auto-generated method stub
		Set<Integer> set = new TreeSet<Integer>();
		int lastNum = 0;
		int count =1;
		while(set.size()<10 && count <=100){
			int temp = count++ * n;
			lastNum = temp;
			System.out.println(temp);
			checkDigits(temp, set);
		}
		if(count<=100)
		return lastNum;
		else
			return -1;
	}

	private static void checkDigits(int temp, Set<Integer> set) {
		// TODO Auto-generated method stub
		while(temp>0){
			int rem = temp%10;
			temp /= 10;
			set.add(rem);
		}
		return;
	}
}
