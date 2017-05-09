package search;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConnectedCell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[][] a = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[i][j] = in.nextInt();
			}
		}
		
		new ConnectedCell().solve(a,N,M);
	}

	private void solve(int[][] a, int n, int m) {
		// TODO Auto-generated method stub
		boolean[][] visited = new  boolean[n][m];
		int ans = -1;
		Map<String,ArrayList<String>> map = takeMap(n,m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
					if(a[i][j]==0)
						continue;
					//System.out.println(i+","+j);
					int temp = visited[i][j]?-1:doDFS(a,visited,i,j,map);
					if(temp>ans)
						ans = temp;
			}
		}
		
		System.out.println(ans);
	}
	
	private Map<String, ArrayList<String>> takeMap(int n, int m) {
		// TODO Auto-generated method stub
		Map<String,ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				String cell = i+","+j;
				int T = i-1, B = i+1, L = j-1, R = j+1;
				if(i!=0 && i!=n-1 && j!=0 && j!=m-1){
					ArrayList<String> list = new ArrayList<String>();
					list.add(T+","+j);//top
					list.add(B+","+j);//bottom
					list.add(i+","+L);//left
					list.add(i+","+R);//right
					
					list.add(T+","+L);//topleft
					list.add(T+","+R);//topright
					list.add(B+","+L);//bottomleft
					list.add(B+","+R);//bottomright
					map.put(cell, list);
				}else if(i==0){
					if(j==0){
						ArrayList<String> list = new ArrayList<String>();
						list.add(B+","+j);//bottom
						list.add(i+","+R);//right
				
						list.add(B+","+R);//bottomright
						map.put(cell, list);
					}else if(j==m-1){
						ArrayList<String> list = new ArrayList<String>();
						list.add(B+","+j);//bottom
						list.add(i+","+L);//left
				
						list.add(B+","+L);//bottomleft
						map.put(cell, list);
					}else{
						ArrayList<String> list = new ArrayList<String>();
						list.add(B+","+j);//bottom
						list.add(i+","+L);//left
						list.add(i+","+R);//right
				
						list.add(B+","+L);//bottomleft
						list.add(B+","+R);//bottomright
						map.put(cell, list);
					}
				}else if(i==n-1){
					if(j==0){
						ArrayList<String> list = new ArrayList<String>();
						list.add(T+","+j);//top
						list.add(i+","+R);//right
						list.add(T+","+R);//topright
						map.put(cell, list);
					}else if(j==m-1){
						ArrayList<String> list = new ArrayList<String>();
						list.add(T+","+j);//top
						list.add(i+","+L);//left
						
						list.add(T+","+L);//topleft
						map.put(cell, list);
					}else{
						ArrayList<String> list = new ArrayList<String>();
						list.add(T+","+j);//top
						list.add(i+","+L);//left
						list.add(i+","+R);//right
						
						list.add(T+","+L);//topleft
						list.add(T+","+R);//topright
						map.put(cell, list);
					}
				}else{
					if(j==0){
						ArrayList<String> list = new ArrayList<String>();
						list.add(T+","+j);//top
						list.add(B+","+j);//bottom
						list.add(i+","+R);//right
						list.add(T+","+R);//topright
						list.add(B+","+R);//bottomright
						map.put(cell, list);
					}else {
						ArrayList<String> list = new ArrayList<String>();
						list.add(T+","+j);//top
						list.add(B+","+j);//bottom
						list.add(i+","+L);//left
						
						list.add(T+","+L);//topleft
						list.add(B+","+L);//bottomleft
						
						map.put(cell, list);
					}
				}
			}
		}
		return map;
	}

	private int doDFS(int[][] a, boolean[][] visited, int m, int n, Map<String, ArrayList<String>> map) {
		// TODO Auto-generated method stub
		int i = m, j = n, ans = 0;
		Stack<String> st = new Stack<String>();
		st.add(m+","+n);
		while(!st.isEmpty()){
			String s = st.pop();
			i = Integer.parseInt(s.split(",")[0]);
			j = Integer.parseInt(s.split(",")[1]);
			if(visited[i][j]){
				continue;
			}
			ans++;
			
			ArrayList<String> list = map.get(s);
			for (int k = 0; k < list.size(); k++) {
				String ele = list.get(k);
				int ii = Integer.parseInt(ele.split(",")[0]);
				int jj = Integer.parseInt(ele.split(",")[1]);
				if(!visited[ii][jj] && a[ii][jj]==1){
					st.add(ele);
				}
			}
			
			visited[i][j] = true;
		}
		return ans;
	}

}
