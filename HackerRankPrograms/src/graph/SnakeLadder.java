package graph;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SnakeLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T-- > 0) {
			int N = in.nextInt();
			int[] ladder = new int[101];
			for (int i = 0; i < N; i++) {
				int start = in.nextInt(), end = in.nextInt();
				ladder[start] = end;

			}
			int M = in.nextInt();
			int[] snake = new int[101];
			for (int i = 0; i < M; i++) {
				int start = in.nextInt(), end = in.nextInt();
				snake[start] = end;
			}
			List<ArrayList<SnakeGraph>> gr = new ArrayList<ArrayList<SnakeGraph>>();
			for (int i = 0; i < 101; i++) {
				gr.add(new ArrayList<SnakeGraph>());
			}

			try {
				for (int i = 1; i < 101; i++) {
					for (int j = 1; j < 7; j++) {
						int sq = i + j;
						if(sq>100)
							continue;
						if (ladder[sq] != 0) {
							gr.get(i).add(new SnakeGraph(ladder[sq]));
						}

						if (snake[sq] != 0) {
							gr.get(i).add(new SnakeGraph(snake[sq]));
						} else {
							gr.get(i).add(new SnakeGraph(sq));
						}

					}
				}
			} catch (Exception e) {
				System.out.println("Exception occured:-"+e.getMessage());
			}

			new SnakeLadder().solve(gr);
		}

	}

	private void solve(List<ArrayList<SnakeGraph>> gr) {
		// TODO Auto-generated method stub
		int[] distance = new int[101];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		Set<Integer> set = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		while (!q.isEmpty()) {
			int vertex = q.remove();
			List<SnakeGraph> list = gr.get(vertex);
			if (set.contains(vertex))
				continue;

			for (int i = 0; i < list.size(); i++) {
				int neighbor = list.get(i).end;
				if (!set.contains(neighbor)) {
					if (distance[neighbor] > distance[vertex] + 1) {
						distance[neighbor] = distance[vertex] + 1;
					}

					q.add(neighbor);
				}
			}

			set.add(vertex);
		}

		System.out.println(distance[100] == Integer.MAX_VALUE ? -1
				: distance[100]);

	}

}

class SnakeGraph {
	int end;

	public SnakeGraph(int end) {
		super();
		this.end = end;
	}

}