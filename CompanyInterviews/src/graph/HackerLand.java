package graph;
import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class HackerLand {
	
	public static void main(String[] args) {
		Scanner in = new  Scanner(System.in);
		int N = in.nextInt(), M = in.nextInt();
		Graph<Integer> graph = new Graph<Integer>(true);
		while(M-->0){
			int x = in.nextInt(), y = in.nextInt(); 
			int pow = in.nextInt();
			//int cost = (int) Math.pow(2, pow);
			
			graph.addEdge(x, y, pow);
		}
		
		Map<Vertex<Integer>, Edge<Integer>> map = new HackerLand()
										.primMST(graph,new Vertex<Integer>(1));
		Map<Integer,Integer> parent = new HashMap<Integer, Integer>();
		
		BigInteger[][] distance = new BigInteger[N][N];
		for(Map.Entry<Vertex<Integer>, Edge<Integer>> m: map.entrySet()){
			Vertex<Integer> key  = m.getKey();
			Edge<Integer> value = m.getValue();
			int lower, higher;
			if(value.getVertex1().getId()>value.getVertex2().getId()){
				lower = (int)value.getVertex2().getId();
				higher = (int)value.getVertex1().getId();
			}else{
				lower = (int)value.getVertex1().getId();
				higher = (int)value.getVertex2().getId();
			}
			BigInteger base =BigInteger.valueOf(2);
			int exponent = value.getWeight();
			distance[lower-1][higher-1] = base.pow(exponent);
			distance[higher-1][lower-1] = base.pow(exponent);
			
			if(!parent.containsKey(key.getId())){
				if(key.getId()==lower){
					parent.put((int) key.getId(), higher);
				}else{
					parent.put((int) key.getId(), lower);
				}
				
			}
			
		}
		BigInteger total = BigInteger.ZERO;
		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance[i].length ; j++) {
				if(i!=j && i<=j){
					if(distance[i][j]!=null){
						total = total.add(distance[i][j]);
					}else{
						BigInteger d = findDistance(distance,parent,i,j);
						total = total.add(d);
						distance[i][j] = distance[j][i] = d;
						
					}
				}
			}
		}
		
		System.out.println(total.toString(2));
	
		
		
		
	}

	private static BigInteger findDistance(BigInteger[][] distance,
			Map<Integer, Integer> map, int x, int y) {
		// TODO Auto-generated method stub
		BigInteger sum = BigInteger.ZERO;
		x++;y++;
		int orgX = x;
		int orgY = y;
		while(x!=y){
			if(distance[orgX-1][y-1]!=null){
				sum =sum.add(distance[orgX-1][y-1]);
				break;
			}else if(distance[orgY-1][x-1]!=null){
				sum =sum.add(distance[orgY-1][x-1]);
				break;
			}
			else if(map.containsKey(y)){
				x = map.get(y);
				
				if(x==orgX && distance[x-1][y-1]!=null){
					sum =sum.add(distance[x-1][y-1]);
					break;
				}else  if(x!=orgX && distance[x-1][y-1]!=null){
					sum =sum.add(distance[x-1][y-1]);
				}else{
					break;
				}
				
				
				if(map.containsKey(x)){
					y = x;
					x = map.get(x);
				}else{
					break;
				}
			}else if(map.containsKey(x)){
				y = map.get(x);
				
				if(y==orgY && distance[y-1][x-1]!=null){
					sum =sum.add(distance[y-1][x-1]);
					break;
				}else  if(y!=orgY && distance[y-1][x-1]!=null){
					sum =sum.add(distance[y-1][x-1]);
				}else{
					break;
				}
				
				if(map.containsKey(y)){
					x = y;
					y = map.get(y);
				}else{
					break;
				}
				
			}
		}
		return sum;
	}

	public Map<Vertex<Integer>, Edge<Integer>> primMST(Graph<Integer> graph,
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
		
		
		return vertexToEdge;
	}
	
	private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e) {
		return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
	}

}
