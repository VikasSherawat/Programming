package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.DisjointSet;

public class Kruskal {
    int[][] graph;
    int vertices;
    int cost;
    public Kruskal(int[][] graph, int vertices){
        this.graph = graph;
        this.vertices = vertices;
    }

    public List<List<Integer>> run(){
        List<List<Integer>> mst = new ArrayList<>();
        List<Edge> sortedEdges = getSortedEdges();
        DisjointSet disjointSet = new DisjointSet(vertices);
        for (int i = 1; i <= vertices; i++) {
            disjointSet.makeset(i);
        }

        for(Edge edge: sortedEdges){
            int sourceParent = disjointSet.find(edge.source);
            int destinationParent = disjointSet.find(edge.destination);

            if (sourceParent != destinationParent) {
                cost+=edge.cost;
                mst.add(Arrays.asList(edge.source,edge.destination));
                disjointSet.union(edge.source,edge.destination);
            }
        }

        return mst;
    }

    public int getMinimumCost(){
        if(this.cost==0){
            run();
        }
        return this.cost;
    }

    private List<Edge> getSortedEdges() {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            edges.add(new Edge(graph[i][0],graph[i][1],graph[i][2]));
        }
        Collections.sort(edges, Comparator.comparingInt(a -> a.cost));
        return edges;
    }
}
