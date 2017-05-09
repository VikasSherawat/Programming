package weekofcode19;

import java.util.*;

public class TwoRobots {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	List<Integer> list = new ArrayList<Integer>();
	while(T-->0){
		int M = in.nextInt(),N=in.nextInt();
		int[][] arr = new int[N][2];
		int count=0;
		while(count<N){
			arr[count][0]=in.nextInt();
			arr[count++][1]=in.nextInt();
		}
		int result = findMinDist(arr,-1,-1,0,1);
		list.add(result);
	}//while loop ends here
	
	for(Integer i: list)
		System.out.println(i);
}

private static int findMinDist(int[][] arr, int robot1, int robot2, int start,int pickRobot) {
	// TODO Auto-generated method stub
	if(start>=arr.length){
		return 0;
	}
	int minD=0;
	if(pickRobot==1){
		if(robot1!=-1)
		minD=Math.abs(arr[start][0]-robot1)+Math.abs(arr[start][1]-arr[start][0]);
		else
			minD = Math.abs(arr[start][1]-arr[start][0]);
		robot1=arr[start][1];
	}else{
		if(robot2!=-1)
		minD=Math.abs(arr[start][0]-robot2)+Math.abs(arr[start][1]-arr[start][0]);
		else
			minD = Math.abs(arr[start][1]-arr[start][0]);
		robot2=arr[start][1];
	}

		return (minD+Math.min(findMinDist(arr, robot1, robot2, start+1, 1), findMinDist(arr, robot1, robot2, start+1,2)));
}
}
