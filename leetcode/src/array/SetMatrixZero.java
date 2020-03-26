package array;

import java.util.Arrays;

public class SetMatrixZero {

    public static void main(String[] args) {
        int[][] m = {{1,2,3,4},{5,0,5,2},{8,9,2,0},{5,7,2,1}};
        new SetMatrixZero().setZeroes(m);
        for(int[] a: m){
            System.out.println(Arrays.toString(a));
        }
    }
    public void setZeroes(int[][] m) {
        for(int i = 0;i<m.length;i++){
            for(int j = 0;j<m[0].length;j++){
                if(m[i][j]==0){
                    makeRowAndColZero(m, i, j);
                }
            }
        }

        for(int i = 0;i<m.length;i++){
            for(int j = 0;j<m[0].length;j++){
                if(m[i][j]==-111){
                    m[i][j]=0;
                }
            }
        }
    }

    private void makeRowAndColZero(int[][] m, int i, int j){
        int s=i-1, e = j;
        while(s>=0){
            if(m[s][e]>0)
                m[s][e]=-111;
            s--;
        }
        s=i+1; e = j;
        while(s<m.length && m[s][e]>0){
            if(m[s][e]>0)
                m[s][e]=-111;
            s++;
        }


        s=i; e = j-1;
        while(e>=0 && m[s][e]>0){
            if(m[s][e]>0)
                m[s][e]=-111;

            e--;
        }

        s=i; e = j+1;
        while(e<m[0].length){
            if(m[s][e]>0)
                m[s][e]=-111;
            e++;
        }


    }
}
