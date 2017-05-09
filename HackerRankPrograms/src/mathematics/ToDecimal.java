package mathematics;

public class ToDecimal {
	public static long toDecimal(int n, int b)
	{
	   long result=0l;
	   int multiplier=1;
	      
	   while(n>0)
	   {
	      result+=n%10*multiplier;
	      multiplier*=b;
	      n/=10;
	   }
	      
	   return result;
	}
}
