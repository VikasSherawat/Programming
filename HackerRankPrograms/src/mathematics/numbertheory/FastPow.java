package mathematics.numbertheory;

import java.math.BigInteger;

public class FastPow {

	static BigInteger fastpow(BigInteger a, BigInteger b, BigInteger mod) {
		BigInteger i,temp;
		BigInteger two = BigInteger.valueOf(2);
		if (b.intValue()==1)
			return a.remainder(mod);
		if (b.intValue()==0)
			return BigInteger.ONE;
		
		if(b.remainder(two).longValue()==0)
		{
		    temp=fastpow(a,b.divide(two),mod);
		    return (temp.multiply(temp)).remainder(mod);
		}

		else
		{
		    temp=fastpow(a,b.subtract(BigInteger.ONE),mod);
		    return (temp.multiply(a)).remainder(mod);
		}

	}
}
