package array;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        image = new FloodFill().floodFill(image, 1,1,2);
        for(int[] arr: image)
            System.out.println(Arrays.toString(arr));
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length==0)
            return image;


        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] m, int x, int y, int color, int org){
        int r = m.length, c = m[0].length;
        if(x <0 || y <0 || x>=r || y>=c || m[x][y]!=org){
            return;
        }

        m[x][y]=color;
        dfs(m, x-1,y,color, org);
        dfs(m, x,y,color-1, org);
        dfs(m, x+1,y,color, org);
        dfs(m, x,y,color+1, org);
    }
}
