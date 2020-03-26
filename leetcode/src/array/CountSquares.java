package array;

public class CountSquares {
    public static void main(String[] args) {
        int[][] m = {{1,0,1,0,1},{1,0,0,1,1},{0,1,0,1,1},{1,0,0,1,1}};
        System.out.println(new CountSquares().countSquares(m));
    }
    public int countSquares(int[][] m) {
        int size = 1;
        int r = m.length;
        int c = m[0].length;

        int ans = 0;
        for(int i = 0;i<r;i++){
            for(int j =0;j<c;j++){
                if(m[i][j]==0)
                    continue;

                if(i == 0 || j == 0)
                    ans+=1;

                int min = Math.min(m[i-1][j],Math.min(m[i][j-1], m[i-1][j-1]));
                m[i][j]+= min;
                ans += m[i][j];
            }
        }
        return ans;
    }
}
