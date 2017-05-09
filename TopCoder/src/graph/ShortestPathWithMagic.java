package graph;

import java.util.PriorityQueue;

class Node implements Comparable<Node> { 
  int index;
  int numPotions;
  double totalTime;
  
  public Node(int index, double totalTime, int numPotions) { 
    this.index = index;
    this.totalTime = totalTime;
    this.numPotions = numPotions;
  }
  
  @Override
  public int compareTo(Node other) { 
    if(totalTime < other.totalTime) 
      return -1;
      
    if(totalTime > other.totalTime) 
      return 1;
      
    return 0;
  
  }
}
public class ShortestPathWithMagic { 
  
  int V; 
  int k;
  double [][] adjMat;
  double [][] TABLE;
  
  public double dijkstra(double[][] adjMat, double[][] TABLE) { 
    for(int i=0; i<V; i++) 
      for(int j=0; j<=k; j++)
        TABLE[i][j] = Double.MAX_VALUE;
    
    Node startNode = new Node(0, 0, k);
    
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    TABLE[0][k] = 0.0;
    pq.add(startNode);
    
    while(!pq.isEmpty()) { 
      Node top = pq.poll();
      
      if(top.totalTime > TABLE[top.index][top.numPotions]) continue;
      
      for(int i=0; i<V; i++) { 
        if(i == top.index) continue;
        
        if(top.numPotions > 0) { 
          double nextTime = top.totalTime + adjMat[top.index][i]/2.0;
          if(nextTime < TABLE[i][top.numPotions-1]) { 
            pq.add(new Node(i, nextTime, top.numPotions-1));
            TABLE[i][top.numPotions-1] = nextTime;
          }
        }
        
        double nextTime = top.totalTime + adjMat[top.index][i];
        
        if(nextTime < TABLE[i][top.numPotions]) {
          pq.add(new Node(i, nextTime, top.numPotions));
          TABLE[i][top.numPotions] = nextTime;
        }
        
      }
    }
    
    
    double toRet = Double.MAX_VALUE;
    
    for(int i=0; i<=k; i++)
      toRet = Math.min(TABLE[1][i], toRet);
    
    return toRet;
  }
  public double getTime(String [] dist, int k) { 
	  double [][] adjMat;
	  double [][] TABLE;
    V = dist.length;
    this.k = k;
    adjMat = new double[V][V];
    TABLE = new double[V][k+1];
    
    for(int i=0; i<V; i++) { 
      for(int j=0; j<V; j++) { 
        adjMat[i][j] = (double)(dist[i].charAt(j) - '0');
      }
    }
    
    double sol = dijkstra(adjMat,TABLE);  
    return sol;
  }
  
  public static void main(String[] args) {
	int k = 1;
	String[] a = {"076237",
			 "708937",
			 "680641",
			 "296059",
			 "334508",
			 "771980"};
	System.out.println(new ShortestPathWithMagic().getTime(a, k));
  }
 
}