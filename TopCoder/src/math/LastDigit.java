package math;

public class LastDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long S = 472956193893217459l;
		System.out.println(new LastDigit().findX(S));
	}
	
	public 	long findX(long S){
		long ans  = -1l;
		long lo = 1l, hi = S;
		while(lo<hi){
			long m = (lo+hi)/2;
			long sum = digitSum(m);
			if(sum>S){
				hi =m;
			}else if(sum<S){
				lo = m+1;
			}else{
				ans = m;
				break;
			}
		}
		return ans;
	}

	private long digitSum(long m) {
		// TODO Auto-generated method stub
		long ans = m;
		while(m>0){
			m = m/10;
			ans+=m;
		}
		return ans;
	}

}
