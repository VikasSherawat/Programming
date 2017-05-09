package mayworldcodesprint;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Quadraples {
	public static void main(String[] args) {
		new Quadraples().run();
	}

	private void run() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] a = new int[4];
		a[0] = in.nextInt();
		a[1] = in.nextInt();
		a[2] = in.nextInt();
		a[3] = in.nextInt();
		Arrays.sort(a);
		solve(a);
	}

	private void solve(int[] x) {
		// TODO Auto-generated method stub
		 long ans=0;
         int[][] a=new int[x[2]+1][5000];
         int[] ct=new int[x[2]+1];
         for(int i=1;i<=x[2];i++){
             for(int j=i;j<=x[3];j++){
                 ct[i]++;
                 a[i][i^j]++;
             }
         }
         for(int i=x[2]-1;i>=1;i--){
             ct[i]+=ct[i+1];
             for(int j=0;j<5000;j++)
                 a[i][j]+=a[i+1][j];
             
         }
             
         for(int i=1;i<=x[0];i++){
             for(int j=i;j<=x[1];j++){
                 ans+=ct[j]*1L; 
                 ans-=a[j][i^j];
             }
         }
         
         System.out.println(ans);
	}
}
