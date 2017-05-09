package graph;

import java.io.*;
import java.util.*;

import javax.print.attribute.standard.Destination;

public class GCampus {
	
	class Node implements Comparable<Node>{
		int source;
		int destination;
		int weight;
		public Node(int source, int destination, int weight) {
			super();
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node city) {
			// TODO Auto-generated method stub
			if(this.weight<=city.weight)
				return -1;
			else
			return 0;
		}
		
		
	}
	
	static final String FILENAME = "practice";
	static final String QUESTION = "C-";
	static final String SIZE = "small-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME
			+ "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	BufferedReader in;
	PrintWriter out;

	private void solve(int TURN) throws IOException {
		String[] size = in.readLine().split("\\s+");
		int N = Integer.parseInt(size[0]);
		int M = Integer.parseInt(size[1]);
		
		//adjacency List
		List<List<Node>> graph = new ArrayList<List<Node>>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Node>());
		}
		//store road input
		int[][] roads = new int[M][3];
		for (int i = 0; i < M; i++) {
			String[] edge = in.readLine().split("\\s+");
			int a = Integer.parseInt(edge[0]);
			int b = Integer.parseInt(edge[1]);
			int weight = Integer.parseInt(edge[2]);
			
			roads[i][0] = a;
			roads[i][1] = b;
			roads[i][2] = weight;
			Node node = new Node(a,b,weight);
			graph.get(a).add(node);
			node = new Node(b,a, weight);
			graph.get(b).add(node);
		}
		
		int[][] edgeUsed = checkAllCity(graph,N,M);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < roads.length; i++) {
			int s = roads[i][0];
			int d = roads[i][1];
			if(!(edgeUsed[s][d] == 1 || edgeUsed[d][s] ==1) ){
				sb.append(i+" ");
			}
			
		}
		fpl(FORMAT+TURN+SEMICOLON);
		fpl(sb.toString());

	}
	
	private int[][] checkAllCity(List<List<Node>> graph, int nOffice, int mRoads){
		int[][] edgeUsed = new int[nOffice][nOffice];
		int b;
		for (int i = 0; i < nOffice; i++) {
			findUselessRoads(graph, edgeUsed, nOffice, i);
		}
		return edgeUsed;
	}

	private void findUselessRoads(List<List<Node>> graph, int[][] edgeUsed, int nOffice, int source) {
		// TODO Auto-generated method stub
		int aSource = source;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Set<Integer> visited = new HashSet<Integer>();
		Map<Integer, Integer> parentMap = new HashMap<Integer, Integer>();
		long[] distance = new long[nOffice];
		Arrays.fill(distance, Long.MAX_VALUE);
		distance[source] = 0;
		
		
		
		List<Node> list = graph.get(source);
		for(Node n : list){
			pq.add(n);
		}
		visited.add(source);
		while(!pq.isEmpty()){
			Node node = pq.remove();
			source = node.source;
			int dest = node.destination;
			int weight = node.weight;
			
			if(distance[dest] > distance[source]+weight){
				distance[dest] = distance[source]+weight;
				parentMap.put(dest, source);
				list = graph.get(dest);
				for(Node n : list){
					if(visited.contains(n.destination))
						continue;
					pq.add(n);
				}
				visited.add(dest);
			}
		}// while loop ends here
		//
		for(Map.Entry<Integer,Integer> m: parentMap.entrySet()){
			int child = m.getKey();
			int parent =  m.getValue();
			edgeUsed[parent][child] = 1;
			edgeUsed[child][parent] = 1;
		}
	}






	private void configOutput() {
		File file = new File(OUT);
		if (file.exists()) {
			file.delete();
		}
		try {
			out = new PrintWriter(new File(OUT));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void configInput() {
		// TODO Auto-generated method stub
		try {
			FileReader file = new FileReader(IN);
			 in = new BufferedReader(file);
			//in = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int t = Integer.parseInt(in.readLine());
		for (int i = 1; i <= t; i++) {
			// out.print("Case #" + i + ": ");
			solve(i);
		}
		in.close();
		out.flush();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new GCampus().run();
	}

	public void pl(Object inp) {
		System.out.println(inp);
	}

	public void p(Object inp) {
		System.out.print(inp);
	}

	public void fpl(Object inp) {
		out.println(inp);
	}

	public void fp(Object inp) {
		out.print(inp);
	}
}
