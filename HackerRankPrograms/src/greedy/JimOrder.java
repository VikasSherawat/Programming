package greedy;

import java.util.*;
public class JimOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[][] order = new int[num][2];
		int len = order.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < 2; j++) {
				order[i][j]=in.nextInt();
			}
		}//outermost for loop get closed here
		int[] timing = new int[num];
		int[] copy = new int[num];
		for (int i = 0; i < len; i++) {
			copy[i]= timing[i]=order[i][0]+order[i][1];
		}
		Arrays.sort(copy);
		int count=1;
		int result[] = new int[num];
		for (int i = 0; i < copy.length; i++) {
			if(i!=0 && copy[i]==copy[i-1])
				count++;
			else{
				count=1;
				}
			result[i] = findIndex(copy[i],timing,count);
			
			System.out.println(result[i]+" ");
		}
	}

	private static int findIndex(int i, int[] timing,int count) {
		// TODO Auto-generated method stub
		for (int j = 0; j < timing.length; j++) {
			if(timing[j]==i && --count==0){
				return j+1;
			}
		}
		return  -1;
	}

}
