package eightHour;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPath {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = 0;
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(),
			M = in.nextInt();
		
		int[][] table = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				table[i][j] = in.nextInt();
			}
		}
		
		//taking the number of queries
		
		int Q = in.nextInt();
		int[] result  = new int[Q];
		int count=0;
		while(Q-->0){
			int[] queryArray  = new int[4];
			
			for (int i = 0; i < 4; i++) {
				queryArray[i] = in.nextInt();
			}
			
			 start = System.currentTimeMillis();
			result[count++] =  findShortestPath(table, queryArray);
		}
		for(int i : result)
			System.out.println(i);
		Long end = System.currentTimeMillis()-start;
		//System.out.println(end);
	}

	private static int findShortestPath(int[][] table, int[] queryArray) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[table.length][table[0].length];
		int[][] distance = new int[table.length][table[0].length];
		for (int i = 0; i < distance.length; i++) {
			Arrays.fill(distance[i],Integer.MAX_VALUE);
		}
		
		
		int iSource = queryArray[0],
			jSource = queryArray[1],
			iDestination = queryArray[2],
			jDestination = queryArray[3];
		
		distance[iSource][jSource] = table[iSource][jSource];
		
		PriorityQueue<Cell> queue = new PriorityQueue<Cell>();
		Cell cell = new Cell(table[iSource][jSource],iSource+","+jSource);
		queue.add(cell);
		
		while(queue.size()>0){
			String[] currentCell = queue.remove()
					.getLocation()
					.split(",");
			
			int iCoordinate = Integer.valueOf(currentCell[0]),
				yCoordinate = Integer.valueOf(currentCell[1]);
			
			if(visited[iCoordinate][yCoordinate]==false){
				//find out all the neighbors and add them to queue and update their distance from the source
				visited[iCoordinate][yCoordinate]=true;
				
				String top, left, right, bottom; 
				if(yCoordinate!=table[0].length-1){
					right = iCoordinate+","+(yCoordinate+1);
					if(distance[iCoordinate][yCoordinate+1] > distance[iCoordinate][yCoordinate]
							+ table[iCoordinate][yCoordinate+1]){
						distance[iCoordinate][yCoordinate+1] = distance[iCoordinate][yCoordinate]
								+ table[iCoordinate][yCoordinate+1];
					}
					if(!visited[iCoordinate][yCoordinate+1]){
						Cell cell1 = new Cell(table[iCoordinate][yCoordinate+1],right);
						queue.add(cell1);
					}
				}
				if(iCoordinate!=0){
					top = (iCoordinate-1)+","+yCoordinate;
					if(distance[iCoordinate-1][yCoordinate] > distance[iCoordinate][yCoordinate]
							+ table[iCoordinate-1][yCoordinate]){
						distance[iCoordinate-1][yCoordinate] = distance[iCoordinate][yCoordinate]
								+ table[iCoordinate-1][yCoordinate];
					}
					if(!visited[iCoordinate-1][yCoordinate]){
						Cell cell1 = new Cell(table[iCoordinate-1][yCoordinate],top);
						queue.add(cell1);
					}
				}
				if(iCoordinate!=table.length-1){
					bottom = (iCoordinate+1)+","+yCoordinate;
					if(distance[iCoordinate+1][yCoordinate] > distance[iCoordinate][yCoordinate]
							+ table[iCoordinate+1][yCoordinate]){
						distance[iCoordinate+1][yCoordinate] = distance[iCoordinate][yCoordinate]
								+ table[iCoordinate+1][yCoordinate];
					}
					if(!visited[iCoordinate+1][yCoordinate]){
						Cell cell1 = new Cell(table[iCoordinate+1][yCoordinate],bottom);
						queue.add(cell1);
					}
				}
				if(yCoordinate!=0){
					left = iCoordinate+","+ (yCoordinate-1);
					if(distance[iCoordinate][yCoordinate-1] > distance[iCoordinate][yCoordinate]
							+ table[iCoordinate][yCoordinate-1]){
						distance[iCoordinate][yCoordinate-1] = distance[iCoordinate][yCoordinate]
								+ table[iCoordinate][yCoordinate-1];
					}
					if(!visited[iCoordinate][yCoordinate-1]){
						Cell cell1 = new Cell(table[iCoordinate][yCoordinate-1],left);
						queue.add(cell1);
					}
				}
				
				
				
			}//visited coordinate if block ends here
			
		}//while loop ends here
		
		return distance[iDestination][jDestination];
	}// method ends here

}

class Cell implements Comparable<Cell>{
	
	int distance;
	String location;
	
	public Cell(int distance, String location){
		this.distance = distance;
		this.location = location;
	}
	
	@Override
	public int compareTo(Cell cell) {
		// TODO Auto-generated method stub
		int ldistance = cell.getDistance();
		return this.distance - ldistance;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	


	
}
