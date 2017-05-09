package adInfinitum14;
import java.text.DecimalFormat;
import java.util.*;

public class MostDistant {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[][] ar = new int[T][2];
		for (int i = 0; i < T; i++) {
			ar[i][0]=in.nextInt();
			ar[i][1]=in.nextInt();
		}
		double diff = -1.0;
		
		for (int i = 0; i < T-1; i++) {
			double temp = 0.0;
			for (int j = i+1; j < T; j++) {
				temp = Math.sqrt(Math.pow(ar[j][0]-ar[i][0], 2)+Math.pow(ar[j][1]-ar[i][1], 2));
				if(temp>diff)
					diff=temp;
			}
		}//outer for loop
		//DecimalFormat df = new DecimalFormat("#.######");
		//System.out.println(df.format(diff));
		System.out.println(diff);
	}

}
