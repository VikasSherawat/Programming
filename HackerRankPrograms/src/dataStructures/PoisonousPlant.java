package dataStructures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PoisonousPlant {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] arr = new int[T];
		for (int i = 0; i < T; i++) {
			int temp = in.nextInt();
			arr[i] = temp;
		}
		long ans = new PoisonousPlant().solve(arr);
		System.out.println(ans);
	}

	private long solve(int[] arr) {
		// TODO Auto-generated method stub
		Deque<Plant> stack = new LinkedList<Plant>();

		long ans = 0l;
		stack.offerFirst(new Plant(arr[0], 1));

		for (int i = 1; i < arr.length; i++) {
			int curr = arr[i];
			Plant plant = null;
			if(!stack.isEmpty()){
				plant = stack.peekFirst();
				if(curr>plant.poison){
					ans = Math.max(ans, 1);
					stack.offerFirst(new Plant(arr[i], 1));
				}else{
					int days = plant.days;
					while(!stack.isEmpty() && stack.peekFirst().poison>=curr){
						plant = stack.pollFirst();
						days = Math.max(days, plant.days);
					}
					if(stack.isEmpty()){
						stack.offerFirst(new Plant(arr[i], 0));
					}else{
						ans = Math.max(ans, days+1);
						stack.offerFirst(new Plant(arr[i], days+1));
					}
				}
			}else{
				stack.offerFirst(new Plant(arr[i], 0));
			}
		}
		return ans;
	}

}

class Plant {
	int poison;
	int days;

	public Plant(int poison, int days) {
		super();
		this.poison = poison;
		this.days = days;
	}

}
