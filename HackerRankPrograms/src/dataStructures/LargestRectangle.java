package dataStructures;

import java.util.*;

public class LargestRectangle {

	/*
	 * 5 1 2 3 4 5
	 */

	static int mArea = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] arr = new int[T];
		for (int i = 0; i < T; i++) {
			int temp = in.nextInt();
			if (temp > mArea)
				mArea = temp;
			arr[i] = temp;
		}

		int min = solve(arr);
		System.out.println(min);

	}

	private static int solve(int[] input) {
		// TODO Auto-generated method stub
		 Deque<Integer> stack = new LinkedList<Integer>();
	        int maxArea = 0;
	        int area = 0;
	        int i;
	        for(i=0; i < input.length;){
	            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
	                stack.offerFirst(i++);
	            }else{
	                int top = stack.pollFirst();
	                //if stack is empty means everything till i has to be
	                //greater or equal to input[top] so get area by
	                //input[top] * i;
	                if(stack.isEmpty()){
	                    area = input[top] * i;
	                }
	                //if stack is not empty then everythin from i-1 to input.peek() + 1
	                //has to be greater or equal to input[top]
	                //so area = input[top]*(i - stack.peek() - 1);
	                else{
	                    area = input[top] * (i - stack.peekFirst() - 1);
	                }
	                if(area > maxArea){
	                    maxArea = area;
	                }
	            }
	        }
	        while(!stack.isEmpty()){
	            int top = stack.pollFirst();
	            //if stack is empty means everything till i has to be
	            //greater or equal to input[top] so get area by
	            //input[top] * i;
	            if(stack.isEmpty()){
	                area = input[top] * i;
	            }
	            //if stack is not empty then everything from i-1 to input.peek() + 1
	            //has to be greater or equal to input[top]
	            //so area = input[top]*(i - stack.peek() - 1);
	            else{
	                area = input[top] * (i - stack.peekFirst() - 1);
	            }
	        if(area > maxArea){
	                maxArea = area;
	            }
	        }
	        return maxArea;
	}

}
