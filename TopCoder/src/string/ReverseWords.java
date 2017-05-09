package string;

public class ReverseWords {
	public static void main(String[] args) {
		String s  = "India is a beautiful country";
		new ReverseWords().reverseWord(s.toCharArray());
	}
	
	public void reverseWord(char[] s){
		int j = 0;
		for (int i = 0; i < s.length; i++) {
			if(s[i]==' '){
				reverse(s,j,i-1);
				j= i+1;
			}
		}
		reverse(s,j,s.length-1);
		reverse(s,0,s.length-1);
		for(char c : s){
			System.out.print(c);
		}
	}

	private void reverse(char[] st, int s, int en) {
		// TODO Auto-generated method stub
		for (int i = s; i <en; i++) {
			char t = st[i];
			st[i] = st[en];
			st[en] = t;
			en--;
		}
	}
}
