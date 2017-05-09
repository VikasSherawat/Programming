package implementations;
import java.math.BigInteger;
import java.util.*;

public class SherlockBeast {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int result[][] = new int[T][];
		int count=0;
		while(T-->0){
			result[count++]= findDecentNumber(in.nextInt());
		}
		for(int i=0;i<result.length;i++){
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
	
	private static int[] findDecentNumber(int N) {
		// TODO Auto-generated method stub
		int[] res=null;
		if(N%3==0){
			 res = new int[N];
			Arrays.fill(res,5);
			return res;
		}
		
		int div = N/5;
		boolean flag = false;
		
		while(div-->0){
			int i;
			for(i=0;(N-5*i>=0);i++){
				if((N-5*i)%3==0){
					flag = true;
					break;
				}
			}
			if(flag)
			{
				res = new int[N];
				Arrays.fill(res,5);
				int temp=(N-5*i);
				Arrays.fill(res, temp, N, 3);
				break;
			}
		}
		if(res==null){
			res = new int[1];
			res[0]=-1;
			return res;
		}
			
		return res;
	}
}
