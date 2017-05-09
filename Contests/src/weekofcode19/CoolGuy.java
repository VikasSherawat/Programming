package weekofcode19;
import java.math.BigInteger;
import java.util.*;

public class CoolGuy {
 	static BigInteger[] segTree;
	static BigInteger[] arr ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new  Scanner(System.in);
		
		int N = in.nextInt();
		arr = new BigInteger[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=in.nextBigInteger();
		}
		
		
		int nextPowerof2 =  nextPowerOf2(N);
		
		segTree = new BigInteger[nextPowerof2*2-1];
		constructSegTree(segTree,arr,0,N-1,0);
		
		BigInteger ans = BigInteger.valueOf(0);
		
		/*for(BigInteger big: segTree){
			System.out.print(big+" ");
		}
		*/
		/*int a=1,b=3;
		ans = findMin(a,b);
		System.out.println("\nMinimum value in ["+a+","+b+"] "+ans);*/
		for(int a=0;a<N;a++){
			for(int b=a;b<N;b++){
				for(int c=b+1;c<N;c++){
					for(int d=c;d<N;d++){
					int min =Math.min(findMin(a,b).intValue(), findMin(c,d).intValue());
					ans=ans.add(BigInteger.valueOf(min));
					}//d
				}//c
			}//b
		}//a
		BigInteger val = BigInteger.valueOf(1000000007);
		System.out.println(ans.remainder(val));
	}
	 private static BigInteger findMin(int qlow, int qhigh) {
		// TODO Auto-generated method stub
		 int ans = rangeMinimumQuery(segTree, 0, arr.length-1, qlow, qhigh, 0);
		 
		return BigInteger.valueOf(ans);
	}
	private static int rangeMinimumQuery(BigInteger segmentTree[],int low,int high,int qlow,int qhigh,int pos){
	        if(qlow <= low && qhigh >= high){
	            return segmentTree[pos].intValue();
	        }
	        if(qlow > high || qhigh < low){
	            return Integer.MAX_VALUE;
	        }
	        int mid = (low+high)/2;
	        return Math.min(rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1),
	                rangeMinimumQuery(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2));
	    }
	private static void constructSegTree(BigInteger[] segTree,
			BigInteger[] input, int low, int high, int pos) {
		// TODO Auto-generated method stub
		if(low==high){
			segTree[pos]=input[low];
			return;
		}
		int mid = (low+high)/2;
		constructSegTree(segTree, input, low, mid, 2*pos+1);
		constructSegTree(segTree, input, mid+1, high, 2*pos+2);
		segTree[pos]=BigInteger.valueOf(Math.min(segTree[2*pos+1].intValue(), segTree[2*pos+2].intValue()));
	}

	static public int nextPowerOf2(int num){
        if(num ==0){
            return 1;
        }
        if(num > 0 && (num & (num-1)) == 0){
            return num;
        }
        while((num & (num-1)) > 0){
            num = num & (num-1);
        }
        return num<<1;
    }
}
