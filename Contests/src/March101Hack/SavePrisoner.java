package March101Hack;

import java.util.*;
public class SavePrisoner {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	List<Integer> list = new ArrayList<Integer>();
	while(T-->0){
		int N = in.nextInt(), M = in.nextInt(), S = in.nextInt();
		int result = saveThePrisoner(N,M,S);
		list.add(result);
	}
	for(int i: list){
		System.out.println(i);
	}
}

private static Integer saveThePrisoner(int N, int M, int S) {
	// TODO Auto-generated method stub
	// N = numer of prisoner, S = starting position of distribution, M = number of sweets
	M = M%N==0?N:M%N;
	int prisonerLeft = N-S+1;
	if(prisonerLeft<=M){
		int temp = (M+S-1)%N;
		return temp==0?N:temp;
	}else{
		return (S+M-1)%N;
	}
}
}
