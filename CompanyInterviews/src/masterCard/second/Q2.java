package masterCard.second;

import java.util.*;

public class Q2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int _N = in.nextInt();
		int _K = in.nextInt();
		int _L = in.nextInt();
		
		int res = numOfPlaylist(_N, _K, _L);
        System.out.println(res);;
	}

	private static int numOfPlaylist(int N, int K, int L) {
		// TODO Auto-generated method stub
		long permK = 1;
		for ( int i = 0; i <= K ; i++) {
			permK = permK*(N - i);
		}
		
		long atleastOneNotPlayed = 1;
//		for (int i = 1; i < N; i++) {
//			atleastOneNotPlayed = atleastOneNotPlayed * (N-i);
//		}
		long N_f = 1;
		for (int i =1 ;i<=N;i++) {
			N_f = i*N_f;
		}
		long K_f = 1;
		for (int i =1 ;i<=K;i++) {
			K_f = i*K_f;
		}
		long NK_f = 1;
		for (int i =1 ;i<=N-K;i++) {
			NK_f = i*NK_f;
		}
		
		long finalPerm = (long) ((N_f/(K_f*NK_f)) * (Math.pow(N, L-K)));
//		atleastOneNotPlayed = (long) (Math.pow(2, N) - 1);
//		long finalPerm = (int) Math.pow(permK, L - K);
//		return (int) ((finalPerm-atleastOneNotPlayed)%1000000007);
		return (int) ((finalPerm)%1000000007);
	}

}
