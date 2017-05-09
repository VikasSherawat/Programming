package March101Hack;

import java.util.*;

public class JeanieRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int maxCost =-1;
		int costlyDestination=0;
		int N = in.nextInt();
		int K = in.nextInt();
		Map<Integer,Integer> letters = new TreeMap<Integer, Integer>();
		ArrayList<ArrayList<Node>> cityList = new ArrayList<ArrayList<Node>>(N+1);
		for (int i = 1; i <=N; i++) {
			cityList.add(new ArrayList<Node>());
		}
		for (int i = 0; i < K; i++) {
			letters.put(in.nextInt(),1);
		}
		
		for (int i = 0; i < N-1; i++) {
			int S = in.nextInt();
			int D = in.nextInt();
			int C = in.nextInt();
			if(C > maxCost){
				maxCost = C;
				costlyDestination = D;		
			}
			cityList.get(S).add(new Node(D,C));
		}
		int minDistance = findMinDistance(cityList,letters,costlyDestination);
		System.out.println(minDistance);
		in.close();
	}

	private static int findMinDistance(ArrayList<ArrayList<Node>> cityList,
			Map<Integer,Integer> letters, int costlyDestination) {
		// TODO Auto-generated method stub
		
		return 0;
	}

}

class Node implements Comparable<Node>{
    int destination, cost;
    Node(int destination, int cost){
        this.destination = destination; this.cost = cost;
    }
    
    public int compareTo(Node x){
        return Integer.valueOf(this.cost).compareTo(x.cost);
    }
}
