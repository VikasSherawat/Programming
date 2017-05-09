package graph;

import java.io.*;
import java.util.*;

import tree.Tree;



public class SyncShopping {
	Scanner in;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SyncShopping().run();
	}

	private void run() {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		int N = in.nextInt(),
			M = in.nextInt(),
			K = in.nextInt();
		Malls[][] arr = new Malls[N][M];
		
			
		for (int i = 1; i <= N; i++) {
			int numberofFish = in.nextInt();
			List<Integer> fishList = new ArrayList<Integer>();
			for (int j = 0; j < numberofFish; j++) {
				fishList.add(in.nextInt());
			}
			Malls malls = new Malls();
			malls.setSource(i);
			malls.setNumberFish(numberofFish);
			malls.setFishList(fishList);
			arr[i-1][i-1] = malls;
		}
		
		for (int i = 1; i <= N ; i++) {
			int source = in.nextInt(),
				destination = in.nextInt(),
				cost = in.nextInt();
			
			Malls  mall = new Malls();
			mall.setSource(source);
			mall.setDestination(destination);
			mall.setCost(cost);
			
			arr[source-1][destination-1] = mall;
			
			mall = new Malls();
			mall.setSource(destination);
			mall.setDestination(source);
			mall.setCost(cost);
			
			arr[destination-1][source-1] = mall;
		}
			
		solve(arr,N,M,K);
		
	}
	private void solve(Malls[][] arr, int N, int M, int K) {
		// TODO Auto-generated method stub
		Set<Integer> fishSet = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(i==j){
					Malls mall = arr[i][j];
					List<Integer> list = mall.getList();
					for (int l = 0; l < list.size(); l++) {
						fishSet.add(list.get(l));
					}
					break;
				}
			}
		}
		
		while(fishSet.size()>0){
			
		}
	}

	private void pl(Object o){
		System.out.println(o.toString());
	}

}

class Malls implements Comparable<Malls>{
	int source;
	int destination;
	int cost;
	int numberFish;
	List<Integer> fishList;
	
	public int compareTo(Malls o) {
		// TODO Auto-generated method stub
		if(this.cost<o.cost)
			return -1;
		else if(this.cost>o.cost)
			return 1;
		else
			return 0;
	}
	
	
	
	@Override
	public String toString() {
		String output = null;
		output  = "Source: "+this.source + " Destination: "+this.destination
				+" Cost:"+this.cost;
		return output;
	}



	public int getnumberFish() {
		return numberFish;
	}


	public void setNumberFish(int numberFish) {
		this.numberFish = numberFish;
	}


	public List<Integer> getList() {
		return fishList;
	}


	public void setFishList(List<Integer> list) {
		this.fishList = list;
	}
	
	
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

}
