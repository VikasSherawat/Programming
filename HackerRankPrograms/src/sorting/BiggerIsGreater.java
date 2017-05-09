	package sorting;
	
	import java.util.Arrays;
	import java.util.Scanner;
	
	public class BiggerIsGreater {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
			int T = in.nextInt();
			String[] result = new String[T];
			for (int i = 0; i < T; i++) {
				String inp = in.next();
				result[i]= findString(inp);
			}
			
			for(String str:result){
				System.out.println(str);
			}
		}
	
		private static String findString(String inp) {
			// TODO Auto-generated method stub
			char[] iArr = inp.toCharArray();
			int len = inp.length();
			int index=-1;
			boolean flag = true;
			for (int i = len-2; i >=0; i--) {
				for (int j = len-1; j >i; j--) {
					if(iArr[j]>iArr[i]){
						index =i;
						char temp = iArr[j];
						iArr[j]=iArr[i];
						iArr[i]=temp;
						flag= false;
						break;
					}
				}
				if(!flag)
					break;
			}
			if(flag)
				return "no answer";
			
			Arrays.sort(iArr, index+1, len);
			return String.valueOf(iArr);
		}
	}
