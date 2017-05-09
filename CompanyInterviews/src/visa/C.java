package visa;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class C {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

	}
	
	public int zombieCluster(String[] zombies) {
		int n = zombies.length;
		int numberOfClusters = 0;
		boolean[] visited = new boolean[n];
		
		List<List<Integer>> adjacencyMatrix = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			List<Integer> neighbours = new ArrayList<Integer>();
			for (int j=0; j<n; j++) {
				if (zombies[i].charAt(j) == '1') {
					neighbours.add(j);
				}
			}
			adjacencyMatrix.add(neighbours);
		}
		
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				dfs(adjacencyMatrix, i, visited);
				numberOfClusters++;
			}
		}
		
		return numberOfClusters;
	}
	
	private void dfs(List<List<Integer>> adjacencyMatrix, int start, boolean[] visited) {
		List<Integer> zombieNeighbours = adjacencyMatrix.get(start);
		for (Integer zombie:zombieNeighbours) {
			if(!visited[zombie]) {
				visited[zombie] = true;
				dfs(adjacencyMatrix, zombie, visited);
			}
		}
	}

}
