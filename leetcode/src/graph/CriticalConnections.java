package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnections {
    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> con) {
        int[] low = new int[n], disc = new int[n];
        Arrays.fill(disc, -1);
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(List<Integer> ls : con){
            int to = ls.get(0), from = ls.get(1);
            graph[to].add(from);
            graph[from].add(to);
        }

        for(int i =0;i<n;i++){
            if(disc[i] == -1){
                dfs(i,low, disc, graph, i, ans);
            }
        }

        return ans;
    }

    private void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, int par,List<List<Integer>> ans){
        low[u] = disc[u] = ++time;

        for(int i =0;i<graph[u].size();i++){
            int v = graph[u].get(i);

            if(v == par) continue;

            if(disc[v] ==-1){
                dfs(v, low, disc, graph, u, ans);
                low[u] = Math.min(low[u], low[v]);
                if(low[v]>disc[u]){
                    ans.add(Arrays.asList(u,v));
                }
            }else{
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
