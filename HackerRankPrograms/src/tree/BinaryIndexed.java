package tree;
import java.util.*;
import java.math.BigInteger;

public class BinaryIndexed {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,9,4,6,3,7,5};
		int[] bIndexArr = new BinaryIndexed().getBITTree(arr);
		System.out.println(Arrays.toString(bIndexArr));
		Scanner in = new Scanner(System.in);
		int sum = in.nextInt();
		int total = findSum(bIndexArr,sum);
		System.out.println("\nSum is "+total);
	}
	
	public int[] getBITTree(int[] arr){
		int bIndexArr[] = new int[arr.length+1];
		for (int i = 0; i < arr.length; i++) {
			updateBinaryTree(bIndexArr,arr[i],i+1);
		}
		return bIndexArr;
	} 
	private static int findSum(int[] bIndexArr, int index) {
		// TODO Auto-generated method stub
		int sum=0;
		while(index>0){
			sum+=bIndexArr[index];
			index = getParent(index);
		}
		return sum;
	}

	private static void updateBinaryTree(int[] bIndexArr, int val,int index) {
		// TODO Auto-generated method stub
		while(index<bIndexArr.length){
			bIndexArr[index]+=val;
			index = getNext(index);
		}
		
	}
	
	private static int getNext(int index){
        return index + (index & -index);
    }

	private static int getParent(int index) {
		return index - (index & -index);
	}

}
