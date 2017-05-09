package sorting;

import java.util.*;

public class AlmostSorted {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] ar = new int[N];
		for (int i = 0; i < ar.length; i++) {
			ar[i]=in.nextInt();
		}
		findResult(ar);
	}

	private static void findResult(int[] ar) {
		// TODO Auto-generated method stub
		int count=0;
		int fIndex=0, lIndex=0;
		int len = ar.length;
		for (int i = 0; i < len-1; i++) {
			if(ar[i+1]<ar[i] && count==0){
				count++;
				fIndex=i;lIndex=i+1;
				continue;
			}
			if(ar[i+1]<ar[i]){
				if(count==1){
					lIndex=i+1;
					count++;
					continue;
				}
				count++;
				if(i==lIndex){
					lIndex=i+1;
					continue;
				}else{
					System.out.println("no");
					return;	
				}
			}
		}
		if(count==0){
			System.out.println("yes");
		}else if(count==1 || count==2){
			if(fIndex>0){
				if(ar[lIndex]<ar[fIndex-1]){
					System.out.println("no");
					return;
				}
			}
			if(lIndex<len-1){
				if(ar[fIndex]>ar[lIndex+1]){
					System.out.println("no");
					return;
				}
			}
			System.out.println("yes");
			System.out.println("swap "+(fIndex+1)+" "+(lIndex+1));
		}else{
			if(fIndex>0){
				if(ar[lIndex]<ar[fIndex-1]){
					System.out.println("no");
					return;
				}
			}
			if(lIndex<len-1){
				if(ar[fIndex]>ar[lIndex+1]){
					System.out.println("no");
					return;
				}
			}
			System.out.println("yes");
			System.out.println("reverse "+(fIndex+1)+" "+(lIndex+1));
		}
}
}
