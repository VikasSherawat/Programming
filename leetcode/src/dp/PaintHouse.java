package dp;

import java.util.Arrays;
import java.util.Calendar;

public class PaintHouse {
    boolean[] visit;
    static int count;
    public static void main(String[] args) {
        int[][] a = {{17,2,17},{16,16,5}};
        System.out.println(new PaintHouse().minCost(a));
        System.out.println(count);
    }

    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0){
            return 0;
        }
        int n = costs.length-1;
        visit = new boolean[n+1];
        dp(costs, n,0);
        return Math.min(costs[n][0],Math.min(costs[n][1],costs[n][2]));
    }

    private int dp(int[][] costs, int house, int color){
        count++;
        if(house==0){
             return costs[house][color];
        }

        if(visit[house]){
            return costs[house][color];
        }

        costs[house][0] += Math.min(dp(costs, house - 1, 1), dp(costs, house - 1, 2));
        costs[house][1] += Math.min(dp(costs, house - 1, 0), dp(costs, house - 1, 2));
        costs[house][2] += Math.min(dp(costs, house - 1, 0), dp(costs, house - 1, 1));
        visit[house]=true;
        return costs[house][color];
    }
}
