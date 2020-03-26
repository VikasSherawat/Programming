package backtrack;

public class CampusBikes {
    int[][] w;
    int[][] bikes;
    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] w = {{0,0},{1,1},{2,0}};
        int[][] b = {{1,0},{2,2},{2,1}};

        int ans = new CampusBikes().assignBikes(w,b);
        System.out.println(ans);
    }
    public int assignBikes(int[][] workers, int[][] bikes) {
        this.w = workers;
        this.bikes = bikes;
        dp(0, new boolean[w.length], 0);
        return min;
    }


    private void dp(int pos, boolean[] vis, int d){
        // some terminating condition
        if(pos >= w.length){
            min = Math.min(min, d);
            return;
        }
        if (d > min) {
            return ;
        }

        for(int start = 0;start<bikes.length;start++){
            if (vis[start]) {
                continue;
            }
            vis[start]=true;
            dp(pos+1, vis,d+dis(pos,start));
            vis[start]=false;
        }
    }

    private int dis(int idx, int start){
        return Math.abs(w[idx][0]-bikes[start][0])+Math.abs(w[idx][1]-bikes[start][1]);
    }
}
