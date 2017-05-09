package graph;

import java.util.*;


public class FloydCity {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	            int n = sc.nextInt(), m = sc.nextInt();
	          //  ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>(n+1);
	            TreeMap<Integer,TreeMap<Integer,Integer>> map = new TreeMap<Integer, TreeMap<Integer,Integer>>();
	        
	            while(m-- > 0){
	                int x = sc.nextInt(), y = sc.nextInt(), cost = sc.nextInt();
	               // adj.get(x).add(new Node(y, cost));	 
	                if(map.containsKey(x)){
	                	TreeMap<Integer,Integer> tree = map.get(x);
	                	tree.put(y, cost);
	                }else{
	                	TreeMap<Integer,Integer> t1 = new TreeMap<Integer, Integer>();
	                	t1.put(y, cost);
	                	map.put(Integer.valueOf(x),t1);
	                }
	            }
	            int q = sc.nextInt();
	            int[][] arr = new int[n+1][];
	            for(int i=1;i<=n;i++){
	            	arr[i] = djikstra(i, map, n);
	            }
	            while(q-->0){
	            	int src = sc.nextInt();
	            	int dest = sc.nextInt();
	            	System.out.println(arr[src][dest]==Integer.MAX_VALUE?-1:arr[src][dest]);
	            
	            }
	        
	    }
	    
	    static int[] djikstra(int s, Map<Integer, TreeMap<Integer, Integer>> map, int n){
	        int[] dist = new int[n+1];
	        Arrays.fill(dist, Integer.MAX_VALUE);
	        dist[s] = 0;
	        PriorityQueue<Node> pq = new PriorityQueue<Node>();
	        pq.add(new Node(s, 0));
	        while(pq.size() > 0){
	            Node curr = pq.remove();
	            int currN = curr.destination;
	            if(map.containsKey(currN)){
	            TreeMap<Integer,Integer> tree = map.get(currN);
	            for(Map.Entry<Integer, Integer> m1: tree.entrySet()){
	                if(dist[m1.getKey()] > dist[currN] + m1.getValue()){
	                    pq.add(new Node(m1.getKey(), dist[currN] + m1.getValue()));
	                    dist[m1.getKey()] = dist[currN] + m1.getValue();
	                }
	            }
	            }
	        }
	        
	               return dist;
	    }

}
