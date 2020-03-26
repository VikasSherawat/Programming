package array;

import java.util.Arrays;

public class FlipMatrix {
    public static void main(String[] args) {
        int[][] m  = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        String[][] arr = new String[3][2];
        Arrays.sort(arr,(a,b)->a[1]!=b[1]?a[1].compareTo(b[1]):a[0].compareTo(b[0]));
        System.out.println(new FlipMatrix().matrixScore(m));
    }
    public int matrixScore(int[][] m) {
        int r = m.length, c = m[0].length;

        for(int i = 0;i<r;i++){
            if(m[i][0]==0){
                flipRow(m,i);
            }
        }

        for(int j = 0;j<c;j++){
            int cnt = countOneInColJ(m,j);
            if(!(cnt>=Math.ceil((double)r/2))){
                flipCol(m, j);
            }
        }

        int sum =0;
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                sum += m[i][j] * Math.pow(2,c-1-j) ;
            }
        }
        return sum;
    }

    private void flipCol(int[][] m, int j){
        int r = m.length;
        for(int i =0;i<r;i++){
            m[i][j]= 1-m[i][j];
        }
    }

    private int countOneInColJ(int[][] m, int j){
        int r = m.length;
        int t =0;
        for(int i =0;i<r;i++){
            if(m[i][j]==1)
                t++;
        }

        return t;
    }

    private void flipRow(int[][] m, int i){
        int r = m.length, c = m[0].length;
        for(int j = 0;j<c;j++){
            m[i][j] = 1-m[i][j];
        }

    }
}
