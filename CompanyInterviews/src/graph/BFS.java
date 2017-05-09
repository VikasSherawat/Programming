package graph;

import java.util.*;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T-- > 0) {
			int N = in.nextInt(), M = in.nextInt();
			Graph<Integer> graph = new Graph<Integer>(false);
			for (int i = 0; i < M; i++) {
				int source = in.nextInt();
				int destination = in.nextInt();
				graph.addEdge(source, destination, 6);
			}
			int source = in.nextInt();
			new BFS().solve(graph, source, N);
			System.out.println();

		}

	}

	public void solve(Graph<Integer> graph, int source, int N) {
		// TODO Auto-generated method stub
		Vertex<Integer> vertex = graph.getVertex(source);
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		Set<Long> visited = new HashSet<Long>();
        Queue<Vertex<Integer>> q = new LinkedList<Vertex<Integer>>();

		q.add(graph.getVertex(source));
		distance[source] = 0;
		while(!q.isEmpty()){
			Vertex<Integer> visitingVertex = q.poll();
			if(visitingVertex==null)
				continue;
			if(!visited.contains(visitingVertex.getId())){
				//System.out.println("Visiting vertex id is:"+visitingVertex.getId());
				List<Edge<Integer>> list = visitingVertex.getEdges();
				for(Edge<Integer> e: list){
					
					Vertex v2;
					if(visitingVertex.getId() == e.getVertex1().getId()){
						v2 = e.getVertex2();
					}else{
						v2 = e.getVertex1();
					}
					if(visited.contains(v2.getId()))
						continue;
					
					//System.out.println("Chosen Vertex is: "+v2.getId());
					
					if(distance[(int)v2.getId()] > distance[(int)visitingVertex.getId()] + e.getWeight()){
						distance[(int)v2.getId()] = distance[(int)visitingVertex.getId()] + e.getWeight();
						q.add(v2);
					}
					
				}
				visited.add(visitingVertex.getId());
			}
		}

	

		for (int i = 1; i < distance.length; i++) {
			if(i!=source){
				if(distance[i]==Integer.MAX_VALUE)
					System.out.print("-1"+" ");
				else
					System.out.print(distance[i]+" ");
			}
		}

	}
}
