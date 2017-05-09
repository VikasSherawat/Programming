package bruteforce;

public class ThreeIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 100, b= 50, c = 25;
		int ans = new ThreeIncreasing().minEaten(a, b, c);
		System.out.println(ans);
	}
	
	public int minEaten(int a, int b, int c){
		int ans = 0;
		
		if(c==1 || c==2 || b==1){
			return  -1;
		}
		
		if(b>=c){
			ans += b-(c-1);
			b = c-1;
		}
		
		if(a>=b){
			ans += a-(b-1);
			a = b-1;
		}
		return ans;
	}
}
