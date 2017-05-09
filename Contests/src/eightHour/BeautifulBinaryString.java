package eightHour;

import java.util.Scanner;

public class BeautifulBinaryString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        String str = "010";
        int result = 0;
        long prev = -1, curr =  -1;
        for(int i = s.indexOf(str); i>=0; i = s.indexOf(str, i+1)){
        	curr = i;
        	if(prev ==-1){
        		prev =curr;
        		result++;
        	}
        	else{
        		if(curr-prev>2){
        			result++;
        			prev = curr;
        		}else{
        			prev = curr = -1;	
        		}
        	}
        }
        
        System.out.println(result);

}

}
