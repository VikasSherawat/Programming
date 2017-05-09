package thirtyDaysChallenge;
import java.util.*;
	class Calculator{
		int power(int base, int power) throws Exception{
			int result =0;
			if(base <0 || power <0){
				throw new Exception("n and p should be non-negative");
	
			}else{
				result = (int)Math.pow(base, power);
			}
			return result;
		}
	}
public class Day17 {
	public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        while(T-->0)
        {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try
            {
                int ans=myCalculator.power(n,p);
                System.out.println(ans);
                
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

    }
}
