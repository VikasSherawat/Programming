package search;
import java.util.*;
public class SimilarPair {
	static int T;
	static long res;
	static ArrayList<Integer> g[];
	static long tree[];
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		T = in.nextInt();
		
		g = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++) {
			g[i] = new ArrayList<Integer>();
		}
		
		int done[] = new int[n+1];
		for (int i = 0; i < n - 1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			done[b] = 1;
			g[a].add(b);
		}
		
		int root = -1;
		for (int i = 1; i < done.length; i++) {
			if(done[i] == 0){
				root = i;
				break;
			}
		}
		
		res = 0;
		tree = new long[n+T+1];
		dfs(root);
		System.out.println(res);
	}

	private static void dfs(int root) {
//		System.out.println(root);
		int left = root - T;
		int right = root + T;
		// get the number of its own ancestors in the range [root-T, root+T] 
		//and add it to the total pairs.
		long p = readSum(right) - readSum(left-1);
//		System.out.println(root);
		res += p;
		
		updateNeighbor(root, 1);
		for (int i = 0; i < g[root].size(); i++) {
			int next = g[root].get(i);
			dfs(next);
		}
		
		updateNeighbor(root, -1);
	}

	
	//this function gives the sum till index idx in Tree array
	//Algorithm of finding parent of X
/*	1. Find 2's complement
	2. And it with X
	3. Subtract the result of step 2 from X->it gives parent of X say P
	4. Repeat step 1-3 until P is > 0*/
	static long readSum(int idx){
		long sum = 0;
		while (idx > 0){
			sum += tree[idx];
			// -idx gives the 2's complement of idx
			idx -= (idx & -idx); // this gives the parent of idx(flipping the rightmost bit)
		}
		return sum;
	}
	
	//this function update all the affected node when you insert an element in fenrick tree
	//Algorithm of finding affected neighbor of X
/*	1. Find 2's complement
	2. And it with X
	3. Add the result of 2 to X->it gives neighbor say N
	4. Repeat step 1-3 until R is <= Array.length*/
	
	static void updateNeighbor(int idx ,long val){
		while (idx < tree.length){
			tree[idx] += val;
			idx += (idx & -idx);
		}
	}
}
