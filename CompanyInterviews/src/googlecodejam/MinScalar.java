package googlecodejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class MinScalar {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("C:\\Users\\Vikas Kumar\\Downloads\\A-large-practice.in"));
		List<BigInteger> list = new ArrayList<BigInteger>();
		while(in.hasNext()){
			int T = in.nextInt();
			while(T-->0){
			int N = in.nextInt();
			BigInteger[] A = new BigInteger[N];
			BigInteger[] B = new BigInteger[N];
			for (int i = 0; i < N; i++) {
				A[i] = in.nextBigInteger();
			}
			Arrays.sort(A);
			for (int i = 0; i < N; i++) {
				B[i] = in.nextBigInteger();
			}
			Arrays.sort(B);
			list.add(findMinScalar(A, B));
			}
		}
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("C:\\Users\\Vikas Kumar\\Downloads\\A-large-output.txt", true),
					true);
			out.flush();
			for (int i = 0; i < list.size(); i++) {
			out.write("Case #" + (i+1) + ": " + list.get(i)+"\n");
			out.println();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
		
	}

	private static BigInteger findMinScalar(BigInteger[] a, BigInteger[] b) {
		// TODO Auto-generated method stub
		BigInteger result = BigInteger.ZERO;
		int len = a.length;
		for (int i = 0; i < len; i++) {
			result = result.add(a[i].multiply(b[len - 1 - i]));
		}
		return result;

	}
}