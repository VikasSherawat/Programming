package graph;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinimumPenalty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		List<ArrayList<Penalty>> graph = new ArrayList<ArrayList<Penalty>>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Penalty>());
		}
		for (int i = 0; i < M; i++) {
			int source = in.nextInt();
			int end = in.nextInt();
			int cost = in.nextInt();
			graph.get(source).add(new Penalty(end, cost));
		}

		int A = in.nextInt();
		int B = in.nextInt();
		new MinimumPenalty().findCost(graph, N, M, A, B);
	}

	private void findCost(List<ArrayList<Penalty>> graph, int n, int m, int a,
			int b) {
		// TODO Auto-generated method stub
		int[] distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[a] = 0;
		Set<Integer> set = new HashSet<Integer>();
		//Queue<Integer> q = new LinkedList<Integer>();
		PriorityQueue<Penalty> pq = new PriorityQueue<Penalty>();
		pq.add(new Penalty(a, 0));
		//q.add(a);
		while (!pq.isEmpty()) {
			int vertex = pq.remove().end;
			List<Penalty> list = graph.get(vertex);
			if (set.contains(vertex))
				continue;

			for (int i = 0; i < list.size(); i++) {
				int neighbor = list.get(i).end;
				if (!set.contains(neighbor)) {
					if (distance[neighbor] > (distance[vertex] | list.get(i).cost)) {
						distance[neighbor] = distance[vertex]
								| list.get(i).cost;
					}

					pq.add(list.get(i));
				}
			}

			set.add(vertex);
		}

		System.out.println(distance[b] == Integer.MAX_VALUE ? -1 : distance[b]);

	}

}


class Penalty implements Comparable<Penalty> {
	int end;
	int cost;

	public Penalty(int end, int cost) {
		super();
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Penalty p) {
		// TODO Auto-generated method stub
		if (this.cost < p.cost)
			return -1;
		else if (this.cost > p.cost)
			return 1;
		else
			return 0;
	}

}
