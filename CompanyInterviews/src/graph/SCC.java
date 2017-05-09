package graph;

import java.io.*;
import java.util.*;

public class SCC {
	static final String FILENAME = "practice";
	static final String QUESTION = "B-";
	static final String SIZE = "large-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + "SCC.txt";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME
			+ "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;

	private void solve(int TURN) {
		int ans = 0;
		Graph<Integer> graph = new Graph<Integer>(true);
		while (in.hasNext()) {
			int x = in.nextInt();
			int y = in.nextInt();
			graph.addEdge(x, y);
		}

		List<Set<Integer>> scc = findSCC(graph);
		//List<Set<Vertex<Integer>>> scc = new StronglyConnectedComponent()	.scc(graph);
		List<Integer> list = new ArrayList<Integer>();
		/*for (Set<Vertex<Integer>> s : scc)
			list.add(s.size());*/
		
		for (Set<Integer> s : scc)
			list.add(s.size());

		if (list.size() < 5) {
			int n = 5 - list.size();
			for (int i = 0; i < n; i++) {
				list.add(0);
			}
		}

		Collections.sort(list);
		int count =1;
		for (int i = list.size() - 1; i >= list.size() - 5; i--,count++) {
			if (count == 5)
				pl(list.get(i));
			else
				p(list.get(i) + ",");
		}
	}

	private List<Set<Integer>> findSCC(Graph<Integer> graph) {
		// TODO Auto-generated method stub
		Set<Long> visited = new HashSet<Long>();
		Stack<Long> finishSeq = new Stack<Long>();
		for (Vertex<Integer> v : graph.getAllVertex()) {
			if (!visited.contains(v.getId())) {
				doDFS(graph, v, visited, finishSeq);
			}
		}

		Graph<Integer> reverseGraph = getReverseGraph(graph);
		List<Set<Integer>> list = doDFSAgain(reverseGraph, finishSeq);
		return list;
	}
	
	private void doDFS(Graph<Integer> graph, Vertex<Integer> v,
			Set<Long> visited, Stack<Long> finishSeq) {
		// TODO Auto-generated method stub
		if(visited.contains(v.getId()))
			return;
		
		Set<Long> checked = new HashSet<Long>();
		Stack<Long> stack = new Stack<Long>();
		stack.add(v.getId());
		while (stack.size() > 0) {
			long vertexId = stack.pop();
			visited.add(vertexId);
			Vertex<Integer> vertex = graph.getVertex(vertexId);
			List<Edge<Integer>> neighbours = vertex.getEdges();
			for (Edge<Integer> e : neighbours) {
				long v1 = e.getVertex1().getId();
				long v2;
				if (v1 == vertexId) {
					doDFS(graph, e.getVertex2(), visited, finishSeq);
				} else {
					doDFS(graph, e.getVertex1(), visited, finishSeq);
				}
			}
			finishSeq.add(vertexId);
			
		}
	}

	private List<Set<Integer>> doDFSAgain(Graph<Integer> graph,
			Stack<Long> finishSeq) {
		// TODO Auto-generated method stub
		Set<Long> visited = new HashSet<Long>();
		List<Set<Integer>> list = new ArrayList<Set<Integer>>();
		while (!finishSeq.isEmpty()) {
			long vertexId = finishSeq.pop();

			if (visited.contains(vertexId))
				continue;
			Stack<Long> tempStack = new Stack<Long>();
			tempStack.add(vertexId);
			Set<Integer> set = new HashSet<Integer>();
			while (!tempStack.isEmpty()) {
				long vId = tempStack.pop();
				set.add((int) vId);
				Vertex<Integer> vertex = graph.getVertex(vId);
				for (Edge<Integer> e : vertex.getEdges()) {
					long v1 = e.getVertex1().getId();
					long v2;
					if (v1 == vId)
						v2 = e.getVertex2().getId();
					else
						v2 = v1;
					if (!visited.contains(v2)) {
						tempStack.add(v2);
					}
				}
				visited.add(vId);
			}
			list.add(set);

		}

		return list;
	}

	private Graph<Integer> getReverseGraph(Graph<Integer> graph) {
		// TODO Auto-generated method stub
		Graph<Integer> rGraph = new Graph<Integer>(true);
		for (Edge<Integer> edge : graph.getAllEdges()) {
			long v1 = edge.getVertex1().getId();
			long v2 = edge.getVertex2().getId();
			rGraph.addEdge(v2, v1);
		}
		return rGraph;
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
		File file = new File(IN);
		try {
			in = new Scanner(file);
			// in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		solve(0);
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new SCC().run();
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
