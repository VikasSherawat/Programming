package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaToys {

	/**
	 * @param args
	 * 
5
1 2 3 17 10
[3,2,1,1,1]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int visited[] = new int[10005];
		int n = in.nextInt();
		    for(int i=0 ; i< n ; i++)
		    {
		        int x = in.nextInt();
		        visited[x]++;
		    }
		    int ans = 0;
		    for(int i =0 ; i<= 10000 ; i++)
		    {
		        if(visited[i] != 0)
		         {
		            ans++;
		            for(int j=0 ; j<=4 ; j++)
		           visited[i+j] = 0;
		        }
		    }
		    System.out.println(ans);
	}

}
