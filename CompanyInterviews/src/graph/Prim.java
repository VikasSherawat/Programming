package graph;

import java.util.*;

public class Prim {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		Graph<Integer> graph = new Graph<Integer>(false);
		for (int i = 0; i < M; i++) {
			int x = in.nextInt(), y = in.nextInt(), cost = in.nextInt();
			graph.addEdge(x, y, cost);
		}
		int start = in.nextInt();
		Vertex<Integer> sourceVertex = graph.getVertex(start);
		List<Edge<Integer>> list = new Prim().primMST(graph, sourceVertex);
		int result =0;
		for(Edge<Integer> edge: list){
			result+=edge.getWeight();
		}
		System.out.println(result);

	}

	public List<Edge<Integer>> primMST(Graph<Integer> graph,
			Vertex<Integer> sourceVertex) {
		// TODO Auto-generated method stub
		// binary heap + map data structure
		BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<Vertex<Integer>>();

		// map of vertex to edge which gave minimum weight to this vertex.
		Map<Vertex<Integer>, Edge<Integer>> vertexToEdge = new HashMap<Vertex<Integer>, Edge<Integer>>();

		// stores final result
		List<Edge<Integer>> result = new ArrayList<Edge<Integer>>();

		for (Vertex<Integer> v : graph.getAllVertex()) {
			minHeap.add(Integer.MAX_VALUE, v);
		}

		minHeap.decrease(sourceVertex, 0);
		while (!minHeap.empty()) {
			Vertex<Integer> minVertex = minHeap.extractMin();
			List<Edge<Integer>> list = minVertex.getEdges();
			
			Edge<Integer> spanningTreeEdge = vertexToEdge.get(minVertex);
            if(spanningTreeEdge != null) {
                result.add(spanningTreeEdge);
            }
			if (list != null) {
				for (Edge<Integer> edge : list) {
					Vertex v = getVertexForEdge(minVertex, edge);
					if (minHeap.containsData(v) && minHeap.getWeight(v) >  edge.getWeight()) {
						minHeap.decrease(v, edge.getWeight());
						vertexToEdge.put(v,edge);
					}

				}
			}
		}

		return result;
	}

	private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e) {
		return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
	}

}
