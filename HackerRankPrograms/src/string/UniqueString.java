package string;
import java.util.*;

/*Program to determine whether the string contains all unique
character without using any data structure.*/
public class UniqueString {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String inp = in.nextLine();
		replaceSpace(inp);
	//	findUniqueness(inp);
		
	}

	private static void replaceSpace(String inp) {
		// TODO Auto-generated method stub
		StringTokenizer str = new StringTokenizer(inp," ");
		while(str.hasMoreElements()){
			System.out.print(str.nextToken());
			if(str.hasMoreElements()){
				System.out.print("%20");
			}
		}
		
		/*String[] arr = inp.split("\\s+");
		for(int i=0;i<arr.length-1;i++){
			System.out.print(arr[i]+"%20");
		}
		System.out.print(arr[arr.length-1]);*/
	}

	private static void findUniqueness(String inp) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for(char ch : inp.toCharArray()){
			if(sb.indexOf(String.valueOf(ch))==-1){
				sb.append(ch);
			}else{
				System.out.println("Not unique");
				break;
			}
		}
		if(sb.length()==inp.length())
			System.out.println("Unique");
	}
	
	

}
