package search;

import java.util.*;

public class CountLuck {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		List<String> list = new ArrayList<String>();
		while (T-- > 0) {
			int N = in.nextInt(), M = in.nextInt();
			int endRow = 0, endCol = 0, startRow = 0, startCol = 0;
			char[][] arr = new char[N][M];
			String mindex = "";
			for (int i = 0; i < N; i++) {
				String s = in.next();
				if (s.indexOf('M') != -1) {
					mindex = i + "," + s.indexOf('M');
				}
				arr[i] = s.toCharArray();
			}

			int K = in.nextInt();

			new CountLuck().solve(arr, N, M, mindex, K);
		}

	}

	private void solve(char[][] arr, int n, int m, String mindex, int K) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[n][m];
		Map<String,Integer> map = new TreeMap<String, Integer>();
		Stack<String> st = new Stack<String>();
		st.add(mindex);
		map.put(mindex, 0);
		int i =0,j=0;
		int count = 0;
		while (!st.isEmpty() && count<=K) {
			String s = st.pop();
			 i = Integer.parseInt(s.split(",")[0]);
			 j = Integer.parseInt(s.split(",")[1]);
			
			
			if (visited[i][j]) {
				continue;
			}
			
			if(arr[i][j]=='*')
				break;
			
			int U = i - 1;
			int D = i + 1;
			int L = j - 1;
			int R = j + 1;

			int ways = 0;
			
			if (U >= 0 && arr[U][j] !='X' && !visited[U][j]) {
				st.add(U+","+j);
				ways++;
				map.put(U+","+j, map.get(s));
			}
			
			if (D < n && arr[D][j] !='X' && !visited[D][j]) {
				ways++;
				map.put(D+","+j, map.get(s));
				st.add(D+","+j);
			}
			if (L >= 0 && arr[i][L] !='X' && !visited[i][L]) {
				ways++;
				map.put(i+","+L, map.get(s));
				st.add(i+","+L);
			}
			if (R <  m && arr[i][R] !='X' && !visited[i][R]) {
				ways++;
				map.put(i+","+R, map.get(s));
				st.add(i+","+R);
			}
			
			if(ways>1){
				if (U >= 0 && arr[U][j] !='X' && !visited[U][j]) {
					map.put(U+","+j, map.get(s)+1);
				}
				
				if (D < n && arr[D][j] !='X' && !visited[D][j]) {
					map.put(D+","+j, map.get(s)+1);
				}
				if (L >= 0 && arr[i][L] !='X' && !visited[i][L]) {
					map.put(i+","+L, map.get(s)+1);
				}
				if (R <  m && arr[i][R] !='X' && !visited[i][R]) {
					map.put(i+","+R, map.get(s)+1);
				}
			}
			
			visited[i][j]=true;
		}
		
		count = map.get(i+","+j);
		System.out.println(count==K?"Impressed":"Oops!");
	}

}
