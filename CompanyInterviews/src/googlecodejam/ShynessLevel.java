package googlecodejam;

import java.util.*;

public class ShynessLevel {

	public static void main(String[] args) {
	long start = System.currentTimeMillis();
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	List<Integer> list = new ArrayList<Integer>();
	while(T-->0){
		int N = in.nextInt();
		String inp = in.next();
		int result = findMinPeople(N,inp);
		list.add(result);
	}
	System.out.println(Arrays.toString(list.toArray())
			.replaceAll("[\\[\\]]", "").replaceAll(" ", "")
			.replaceAll(",", "\n"));
	System.out.println("Time taken"+(System.currentTimeMillis()-start));
	
}

	private static int findMinPeople(int N, String inp) {
		// TODO Auto-generated method stub
		int zeroShyPeople = Character.getNumericValue(inp.charAt(0));
		int totalPerson = zeroShyPeople;
		int peopleRequired = 0;
		for (int i = 1; i < N+1; i++) {
			int ithPeople = Character.getNumericValue(inp.charAt(i));
			if(i<=totalPerson){
				totalPerson += ithPeople;
			}else{
				peopleRequired += i-totalPerson;
				totalPerson += i-totalPerson + ithPeople; 
			}
		}
		return peopleRequired;
	}
}
