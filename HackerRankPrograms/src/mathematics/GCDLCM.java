package mathematics;

public class GCDLCM {
	
	public static int GCD(int a, int b)
	{
	   if (b==0) return a;
	   return GCD(b,a%b);
	}
	
	public static int LCM(int a, int b)
	{
	   return b*a/GCD(a,b);
	}
}
