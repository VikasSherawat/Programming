package bitManipulation;

import java.util.*;


public class SansaXoR {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int T =  in.nextInt();
	List<Long> list = new ArrayList<Long>();
	long sum=0l;
	while(T-->0){
		sum=0l;
	int N = in.nextInt();	
	for (int i = 0; i < N; i++) {
		long key = in.nextLong();
		if(i%2==0 && N %2!=0)
			sum^=key;

	}
	list.add(sum);
	}
	for(Long l: list)
		System.out.println(l);
}
}
