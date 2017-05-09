package main;


public class KMP {
	
	public int indexOfPattern(String s, String p){
		
		int[] preArray = getPrefixArray(p);
		int j = 0, i =0;
		for (i = 0; i < s.length() && j < p.length(); i++) {
			if(s.charAt(i) == p.charAt(j)){
				j++;
			}else{
				if(j==0)
					continue;
				
				j = preArray[j-1];
				if(s.charAt(i) == p.charAt(j)){
					j++;
				}else{
					j=0;
				}
			}
		}
		
		
		if(j==p.length()){
			return i-j;
		}else
			return -1;
	}
	
	private int[] getPrefixArray(String p){
		int[] arr = new int[p.length()];
		arr[0] =0;
		int j = 0;
		for (int i = 1; i < p.length(); i++) {
			if(p.charAt(i) ==  p.charAt(j)){
				arr[i] = j+1;
				j++;
			}else{
				
				while(j>0){
					j = arr[j-1];
					if(p.charAt(i) ==  p.charAt(j)){
						arr[i] = j+1;
						j++;
						break;
					}else{
						if(j==0){
							arr[i] = 0;
							break;
						}
						
						j = arr[j-1];
					}
				}
			}
		}
		
		
		return arr;
	}
	
	public static void main(String[] args) {
		String s = "vikaskumarsherawat";
		String p = "viks";
		int index = new KMP().indexOfPattern(s, p);
		System.out.println(s.indexOf(p));
		System.out.println(index);
	}
}
