package worldcodesprint10;

import java.math.BigInteger;
import java.util.Scanner;

public class HappyPermutation {

    static int query(int n, int k) {
        // Complete this function
        int ans  = 0;
        BigInteger perm = findPermutation(n);
        return ans;
    }

    private static BigInteger findPermutation(int n) {
        BigInteger b = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            b = b.multiply(BigInteger.valueOf(i));
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();
            // Find the number of ways to arrange 'n' people such that at least 'k' of them will be happy
            // The return value must be modulo 10^9 + 7
            int result = query(n, k);
            System.out.println(result);
        }
    }
}
