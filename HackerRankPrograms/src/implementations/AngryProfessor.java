package implementations;

import java.util.Scanner;

public class AngryProfessor {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	 int a;
	    int count=0;
	    a = in.nextInt();
	    int[] student=null;
	    int[][] arr = new int[a][2];
	    String[] result = new String[a];
	    for (int i = 0; i < a; i++) {
	        count=0;
	        arr[i][count]=in.nextInt();
	        student =  new int[arr[i][0]];
	        arr[i][++count]=in.nextInt();
	        for (int j = 0; j < arr[i][0]; j++) {
	            student[j]= in.nextInt();  
	        }
	       result[i] = classCancelled(student, arr[i][1]);
	    }
	    for (int i = 0; i < result.length; i++) {
	        System.out.println(result[i]);
	    }
	    }
	    public static String classCancelled(int[] arr, int num){
	    int count=0;
	    for (int i = 0; i < arr.length; i++) {
	        if(arr[i]<=0)
	            count++;
	    }
	    if(count>=num)
	    return "NO";
	    else
	        return "YES";
}
}
