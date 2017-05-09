package hourrank20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vikas on 2/5/17.
 */
public class PerfectSeq {
    static long countSubs(String s){
        // Complete this function
        int C = 1000000007;
        long ans = 0L;
        int[] a = getArray(s);
        List<Long> ab = new ArrayList<>();
        int ablen = Math.min(a[0],a[1]);
        for (int i = 1; i <=ablen ; i++) {
            long k = select(a[0],a[1],i);
            ab.add(k);
        }
        return ans%C;
    }

    private static long select(int a, int b, int c) {
        return 0;
    }

    private static int[] getArray(String s) {
        int[] a = new int[4];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)-'a']++;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Return the number of non-empty perfect subsequences mod 1000000007
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            long result = countSubs(s);
            System.out.println(result);
        }
    }
}
