package googlecodejam.sixteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class CoinJamTest {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("test-c.in"));
		while (s.hasNext()) {
			String number = s.next();
			int[] factors = new int[9];
			for (int i = 0; i < 9; i++) {
				factors[i] = s.nextInt();
			}
			for (int base = 2; base <= 10; base++) {
				BigInteger bigInteger = new BigInteger(number, base);
				if (!bigInteger.remainder(
						new BigInteger(String.valueOf(factors[base - 2])))
						.equals(BigInteger.ZERO)) {
					System.err.println("Wrong factor of " + number
							+ " for base " + base);
					break;
				}
			}
		}
		s.close();
	}
}
