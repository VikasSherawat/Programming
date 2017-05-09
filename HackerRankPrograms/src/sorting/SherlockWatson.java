package sorting;
import java.util.*;

public class SherlockWatson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N= in.nextInt(),K=in.nextInt(), Q=in.nextInt();
		int[] ar = new int[N];
		int[] idx = new int[Q];
		for (int i = 0; i < ar.length; i++) {
			ar[i]=in.nextInt();
		}
		for (int i = 0; i < idx.length; i++) {
			idx[i]=in.nextInt();	
		}
		rotateArray(ar,K);
		for (int i : idx) {
			System.out.println(ar[i]);
		}
	}

	private static void rotateArray(int[] ar, int k) {
		// TODO Auto-generated method stub
		int length = ar.length, temp=0;
		int rotate = k%length;
		int[] ar1 = ar.clone();
		
		for (int i = 0; i <ar1.length; i++) {
			if(i+rotate>ar1.length-1){
				temp = (i+rotate)%length;
				ar[temp]=ar1[i];
			}else
			{
				ar[i+rotate]=ar1[i];
			}
		}
	}

}
