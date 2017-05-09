package dp;

public class RepeatStringEasy {


	public static void main(String[] args) {
		String s = "frankfurt";
		System.out.println(new RepeatStringEasy().maximalLength(s));
	}

	public int maximalLength(String s) {
		int max = 0;
		for (int secondStart = 1; secondStart <= s.length() - 1; secondStart++) {
			String a = s.substring(0, secondStart);
			String b = s.substring(secondStart);
			max = Math.max(max,LCS(a,b));

		}
		return max * 2;
	}
	
	public int LCS(String a, String b) {
		// TODO Auto-generated method stub
		int[][] lcs = new int[b.length()+1][a.length()+1];
		for (int i = 1; i <lcs.length ; i++) {
			int len = lcs[i].length;
			for (int j = 1; j < len; j++) {
				char ac = a.charAt(j-1);
				char bc = b.charAt(i-1);
				if(ac == bc){
					lcs[i][j] = lcs[i-1][j-1]+1;
				}else{
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		return lcs[lcs.length-1][lcs[0].length-1];
	}

}
