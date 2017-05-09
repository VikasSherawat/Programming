package lazada;

import java.util.Scanner;

class Solution1 {


	public static int findMaxLen(String s){
        String[] arr = s.split("\\d+");
        int max = -1;
        for (String inp:arr) {
            boolean hasUppercase = !inp.equals(inp.toLowerCase());
            if(hasUppercase)
                max = Math.max(max, inp.length());
        }

        return max;
    }


    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
		String inpInput = in.nextLine();
		System.out.println(findMaxLen(inpInput));
	}

}
