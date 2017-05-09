package string;

public class SquareFree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "qwertyuiopasdfghjklzxcvbnm";
		System.out.println(new SquareFree().isSquareFree(s));
	}
	
	public String isSquareFree(String s){
		String sf = "square-free";
		String nsf = "not square-free";
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				if(squareFree(s.substring(i, j)))
					return nsf;
			}
		}
		
		return sf;
	}

	private boolean squareFree(String s) {
		// TODO Auto-generated method stub
		if(s.length()%2==1)
			return false;
		int l = s.length();
		if(s.substring(0, l/2).equalsIgnoreCase(s.substring(l/2)))
				return true;
		else
			return false;
	}
}
