package googlecodejam.apac;

import java.io.*;
import java.util.*;

public class BadHorse {
	static final String FILENAME = "practice-2";
	static final String QUESTION = "A-";
	static final String SIZE = "small-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME
			+ "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;

	private void solve(int TURN) {

		int T = in.nextInt();
		String[][] names = new String[T][2];
		Graph<Integer> graph = new Graph<Integer>(false);
		Map<String, Integer> map = new HashMap<String, Integer>();
		int count = 0;
		for (int i = 0; i < T; i++) {
			String first = in.next();
			String second = in.next();
			if (!map.containsKey(first)) {
				map.put(first, ++count);
			}
			if (!map.containsKey(second)) {
				map.put(second, ++count);
			}

			graph.addEdge(map.get(first), map.get(second));
			in.nextLine();

		}
		boolean ans = isGraphBipartite(graph,graph.getVertex(1),count);

		if (ans)
			fpl(FORMAT + TURN + SEMICOLON + "Yes");
		else
			fpl(FORMAT + TURN + SEMICOLON + "No");
	}


	private boolean isGraphBipartite(Graph<Integer> graph,
			Vertex<Integer> sourceVertex, int N) {
		// TODO Auto-generated method stub
		// 0 for blue and 1 for red
		int[] bipartite = new int[N+1];
		Set<Vertex<Integer>> visited = new HashSet<Vertex<Integer>>();
		Arrays.fill(bipartite, -1);
		Queue<Vertex<Integer>> stack = new ArrayDeque<Vertex<Integer>>();
		stack.add(sourceVertex);
		bipartite[1] = 1;
		while(!stack.isEmpty()){
			Vertex<Integer> v = stack.remove();
			int parentColor = bipartite[(int)v.getId()];
			for(Vertex<Integer> child: v.getAdjacentVertexes()){
				if(!visited.contains(child) && !stack.contains(child)){
					stack.add(child);
				}
				int childIndex = (int)child.getId();
				if(bipartite[childIndex]==-1){
					if(parentColor==1)
						bipartite[childIndex] = 0;
					else
						bipartite[childIndex] =1;
				}else if(parentColor==bipartite[childIndex]){
					return false;
				}else{
					continue;
				}
			}
			visited.add(v);
		}
		
		return true;
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
			//in = new Scanner(System.in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
		configInput();
		configOutput();
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			// out.print("Case #" + i + ": ");
			solve(i);
		}
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new BadHorse().run();
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
