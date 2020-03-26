package array;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AlienOrder {

    int N = 26;
    public String alienOrder(String[] words) {
        boolean[][] graph = new boolean[N][N];
        int[] visited = new int[N];
        //build graph
        buildGraph(graph, visited, words);
        StringBuilder res = new StringBuilder();
        for(int i =0;i<N;i++){
            if(visited[i]==0){
                if(!dfs(graph, visited, i, words, res)) return "";
            }
        }

        return res.reverse().toString();
    }

    private boolean dfs(boolean[][] graph,  int[] visited, int i, String[] words, StringBuilder res){
        visited[i]=1;
        for(int j= 0;j<N;j++){
            if(graph[i][j]){
                if(visited[j]==1) return false;
                else if(visited[j]==0){
                    if(!dfs(graph, visited, j, words, res)) return false;
                }
            }
        }

        visited[i]=2;
        res.append((char)(i+'a'));
        return true;
    }

    private void buildGraph(boolean[][] graph,  int[] visited, String[] words){
        Arrays.fill(visited,  -1);
        for(int i = 0;i<words.length;i++){
            for(char c: words[i].toCharArray()){
                visited[c-'a']=0;
            }

            if(i>0){
                String w1 = words[i-1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for(int j=0;j<len;j++){
                    char a = w1.charAt(j), b= w2.charAt(j);
                    if(a!=b){
                        graph[a-'a'][b-'a']=true;
                        break;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String ans = new AlienOrder().alienOrder(words);
        System.out.println(ans);
    }
}
