package graph;

import java.util.*;
class Node implements Comparable<Node>{
    int destination, cost;
    Node(int destination, int cost){
        this.destination = destination; this.cost = cost;
    }
    
    public int compareTo(Node x){
        return Integer.valueOf(this.cost).compareTo(x.cost);
    }
}
