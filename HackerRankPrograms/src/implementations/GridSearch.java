package implementations;

import java.util.*;

public class GridSearch {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        String[] result = new String[t];
	        for(int a0 = 0; a0 < t; a0++){
	            int R = in.nextInt();
	            int C = in.nextInt();
	            String G[] = new String[R];
	            for(int G_i=0; G_i < R; G_i++){
	                G[G_i] = in.next();
	            }
	            int r = in.nextInt();
	            int c = in.nextInt();
	            String P[] = new String[r];
	            for(int P_i=0; P_i < r; P_i++){
	                P[P_i] = in.next();
	            }
	            result[a0]=findMatch(G,P);
	        }
	        for (String string : result) {
				System.out.println(string);
			}
	}// main function ends here
	
	/*	
	1234567890  
	0987654321  
	1111111111  
	1111111111  
	2222222222
	
	// Pattern 
	876543  
	111111  
	111111
	*/
	
private static String findMatch(String[] g, String[] p) {
	// TODO Auto-generated method stub
	TreeSet<Integer> sets = new TreeSet<Integer>();
	int count=0;
	for (int i = 0; i < g.length-p.length; i++) {
		for (int j = count; j < p.length; j++) {
			int ele = g[i].indexOf(p[j]);
			//System.out.println("Index of "+p[j]+ " in the string "+g[i]+" is :"+ele);
			if(ele==-1)
				break;
			else{
				sets.add(ele);
				count++;
				break;
			}
			}
		}
	if(sets.size()==1 && count==p.length)
		return "YES";
	else
		return "NO";
	}
}
