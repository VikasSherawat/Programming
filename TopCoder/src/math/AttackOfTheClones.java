package math;

public class AttackOfTheClones {
	public int count(int[] firstWeek, int[] lastWeek){
		int ans = 0;
		for (int i = 0; i < lastWeek.length; i++) {
			for (int j = 0; j < firstWeek.length; j++) {
				if(firstWeek[j]==lastWeek[i]){
					ans = Math.max(ans, Math.abs(j-i)+1);
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] firstWeek = {8,4,5,1,7,6,2,3};
		int[]  lastWeek = {2,4,6,8,1,3,5,7};
		System.out.println(new AttackOfTheClones().count(firstWeek, lastWeek));
	}
}
