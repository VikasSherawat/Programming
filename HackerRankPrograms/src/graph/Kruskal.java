package graph;

import java.util.*;

public class Kruskal {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		Graph<Integer> graph = new Graph<Integer>(false);
		while(M-->0){
			int source = in.nextInt(),
				destination = in.nextInt(),
				weight = in.nextInt();
				graph.addEdge(source, destination, weight);
		}
		
		int start = in.nextInt();
		
		List<Edge<Integer>> result = new Kruskal().minSpanning(graph, start);
		long minDistance =0;
		for(Edge<Integer> edge: result){
			minDistance += edge.getWeight();
		}
		
		System.out.println(minDistance);
			
	}

	public List<Edge<Integer>> minSpanning(Graph<Integer> graph, int start) {
		// TODO Auto-generated method stub
		DisjointSet disjointSet = new  DisjointSet();
		EdgeComparator comparator = new EdgeComparator();
		
		List<Edge<Integer>> edgeList = graph.getAllEdges();
		Collections.sort(edgeList,comparator);
		
		for(Vertex<Integer> v: graph.getAllVertex()){
			disjointSet.makeSet(v.getId());
		}
		List<Edge<Integer>> result = new ArrayList<Edge<Integer>>();
		
		for(Edge<Integer> edge: edgeList){
			long root1 = disjointSet.findSet(edge.getVertex1().getId());
			long root2 = disjointSet.findSet(edge.getVertex2().getId());
			
			if(root1 == root2){
				continue;
			}else{
				result.add(edge);
				disjointSet.union(edge.getVertex1().getId(), edge.getVertex2().getId());
			}
		}
		
		return result;
	}

	
}
class EdgeComparator implements Comparator<Edge<Integer>> {
   
    public int compare(Edge<Integer> edge1, Edge<Integer> edge2) {
        if (edge1.getWeight() <= edge2.getWeight()) {
            return -1;
        } else {
            return 1;
        }
    }
}