package backtrack;

import java.util.Arrays;

public class PathWithMaxGold {
    public static void main(String[] args) {
        int[][] grid = {{1,0,7,0,0,0},{2,0,6,0,1,0},{3,5,6,7,4,2},{4,3,1,0,2,0},{3,0,5,0,20,0}};
        int ans = new PathWithMaxGold().getMaximumGold(grid);
        System.out.println(ans);
    }
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]!=0){
                    ans = Math.max(ans, dfs(grid,i,j,0,new boolean[row][col]));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int r, int c, int sum, boolean[][] vis){

        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0 || vis[r][c])
            return 0;

        sum+= grid[r][c];
        vis[r][c]=true;
        int max = Math.max(sum, dfs(grid,r+1,c,sum, vis));
        max = Math.max(max, dfs(grid,r-1,c,sum,vis));
        max = Math.max(max, dfs(grid,r,c+1,sum,vis));
        max = Math.max(max, dfs(grid,r,c-1,sum,vis));
        vis[r][c]=false;
        return max;
    }
}
