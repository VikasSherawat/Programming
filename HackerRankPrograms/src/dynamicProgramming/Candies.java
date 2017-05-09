package dynamicProgramming;

import java.util.Scanner;

public class Candies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] rate = new int[T];
		int[] candies = new int[T];
		for (int i = 0; i < rate.length; i++) {
			rate[i]=in.nextInt();
			candies[i]=1;
		}
		
		if(rate[0]>rate[1]){
			candies[0]+=1;
		}
		
		for (int i = 1; i < rate.length-1; i++) {
			if(rate[i]>rate[i-1]){
				candies[i]=candies[i-1]+1;
			}
			if(rate[i]>rate[i+1] && candies[i]<=candies[i+1]){
				candies[i]=candies[i+1]+1;
			}
		}
		if(rate[rate.length-1]>rate[rate.length-2]){
			candies[candies.length-1]= candies[candies.length-2]+1;
		}
		
		for (int i = rate.length-2; i >0; i--) {
			if(rate[i]>rate[i+1]){
				if(candies[i]<=candies[i+1]){
					candies[i]=candies[i+1]+1;
				}
			}//first if block
			if(rate[i]>rate[i-1]){
				if(candies[i]<=candies[i-1]){
					candies[i]=candies[i-1]+1;
				}
			}
			
		}//for loop ends here
		
		if(rate[0]>rate[1] && candies[0]<=candies[1]){
			candies[0]+=candies[1]+1;
		}
	/*	System.out.println("Rating array values are");
		for (int i : rate) {
			System.out.print(i+",");
		}
		System.out.println();
		System.out.println("Candies array after assigning candies are---");
		
		for (int i : candies) {
			System.out.print(i+",");
		}
		System.out.println();*/
		int sum=0;
		for (int i : candies) {
			sum+=i;
		}
		System.out.println(sum);
		
	}

}
