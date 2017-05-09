package graph;

import java.io.*;
import java.util.*;

public class DijkstraCourseEra {
	static final String FILENAME = "dijkstraData";
	static final String QUESTION = "B-";
	static final String SIZE = "large-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + FILENAME + ".txt";
	static final String OUT = FILEPATH + FILENAME + "-answer.txt";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;

	private void solve(int TURN) {
		Graph<Integer> graph = new Graph<Integer>(false);
		while (in.hasNext()) {
			String row = in.nextLine();
			String[] verticesArray = row.split("\\s+");
			int source = Integer.parseInt(verticesArray[0]);
			for (int i = 1; i < verticesArray.length; i++) {
				String inp = verticesArray[i];
				if (inp.indexOf(",") != -1) {
					String[] vertices = inp.split(",");
					int destination = Integer.parseInt(vertices[0]);
					int weight = Integer.parseInt(vertices[1]);
					graph.addEdge(source, destination, weight);
				}
			}
		}
		
		Vertex<Integer> sourceVertex = new Vertex<Integer>(1);
		Map<Vertex<Integer>, Integer> distance = new Dijkstra()
				.shortestPath(graph, sourceVertex);
		
		int[] arr = {7,37,59,82,99,115,133,165,188,197};
		for (int i = 0; i < arr.length; i++) {
			Vertex<Integer> dest = new Vertex<Integer>(arr[i]);
			if(distance.containsKey(dest)){
				p(distance.get(dest)+",");
			}else{
				p("1000000,");
			}
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
		solve(0);
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new DijkstraCourseEra().run();
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
