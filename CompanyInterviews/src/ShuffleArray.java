import java.util.Random;

/**
 * Created by vikas on 21/4/17.
 */
public class ShuffleArray {
    public static void shuffleArray(int[] a) {
        int n = a.length;
        Random random = new Random();
       int j = 0;
        for (int i = 0; i < n; i++) {
            j =random.nextInt(n - i);
            int change = i + j;
            swap(a, i, change);
        }
    }

    private static void swap(int[] a, int i, int change) {
        int helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        shuffleArray(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
