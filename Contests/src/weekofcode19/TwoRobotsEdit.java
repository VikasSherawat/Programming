package weekofcode19;

import java.util.*;
public class TwoRobotsEdit {
	
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int z = in.nextInt();
	int[] result = new int[z];
	int count=0;
    while(z-->0){
    int m = in.nextInt(), n = in.nextInt();
    int a[] = new int[n];
    int b[] = new int[n];
    for (int i = 0; i < b.length; i++) {
		a[i]=in.nextInt();
		b[i]=in.nextInt();
	}
    result[count++] = solve(m,n,a,b);
    }
    for(int i: result){
    	System.out.println(i);
    }
}
private static int solve(int m, int n, int[] a, int[] b) {
	// TODO Auto-generated method stub
    if (n == 0) return 0;
    int[][] dp = new int[n+1][m+1];
    for(int i=2;i<=n;++i)
        for(int j=1;j<=m;++j) 
        dp[i][j] = Integer.MAX_VALUE;

    for(int j=1;j<=m;++j)
        dp[1][j] = Math.abs(b[0] - a[0]);

    for(int i=2;i<=n;++i)
        for(int j=1;j<=m;++j) 
    {
        dp[i][b[i - 2]] = Math.min(dp[i][b[i-2]], dp[i-1][j] + Math.abs(j - a[i-1]) + Math.abs(a[i-1] - b[i-1]));
        dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + Math.abs(b[i-2] - a[i-1]) + Math.abs(a[i-1] - b[i-1]));
    }
    int sol = Integer.MAX_VALUE;
    for(int j=1;j<=m;++j)
        sol = Math.min(sol, dp[n][j]);
    return sol;
}

/*private static void te() {
	// TODO Auto-generated method stub
	int size = in.nextInt();
	int m = in.nextInt(); 
	 int[] a = new int[m+1];
	 int[] b = new int[m+1];
	 int[][] dp = new int[m+1][m+1];
	for(int i=1;i<=m;i++){
		a[i]=in.nextInt();
		b[i]=in.nextInt();
	}
	
	for(int i=1;i<m;++i){
		for(int j=1;j<m;++j){
			dp[i][j]=Integer.MAX_VALUE;
		}
	}
	
	int res = Integer.MAX_VALUE;
	
	for(int i = 0; i < m; ++i) {
        for(int j = i; j <= m; ++j) {
            if(j == m) {
                res = Math.min(res, dp[i][j]);
                continue;
            }
            int me = dp[i][j];
            dp[i][j+1] = Math.min(dp[i][j+1], me + dist(j, j+1,a,b));
            dp[j][j+1] = Math.min(dp[j][j+1], me + dist(i, j+1,a,b));
        }
	}
	System.out.println(res);
}

static int dist(int i, int j, int[] a, int[] b) {
    if(i == 0) return Math.abs(b[j] - a[j]);
    return Math.abs(a[j]-b[i]) + Math.abs(b[j] - a[j]);
}*/
}
