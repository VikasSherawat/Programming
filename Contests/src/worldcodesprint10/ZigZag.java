package worldcodesprint10;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ZigZag {
    static final String FILENAME = "attempt0";
    static final String QUESTION = "A-";
    static final String SIZE = "small";
    static final String FILEPATH = "/home/vikas/Downloads/";
    static final String IN = FILEPATH + QUESTION + SIZE + ".in";
    static final String OUT = FILEPATH + QUESTION + SIZE + "-answer.in";
    String FORMAT = "Case #";
    String SEMICOLON = ": ";
    Scanner in;
    PrintWriter out;
    BufferedReader br;

    private void solve(int TURN) throws Exception {
        int ans = 0;
        int[] arr = sarr2IntArr();
        List<Integer> ls = getList(arr);
        ans = makeZigZag(ls);
        pl(ans);
    }

    private int makeZigZag(List<Integer> ls) {
        int ans = 0;
        for (int i = 0; i < ls.size() - 2;) {
            int zig = zigZag(ls, i);
            if (zig != 0) {//increasing or decreasing
                ls.remove(i+1);
                ans++;
            } else { //zigZag
                i++;
                continue;
            }
        }
        return ans;
    }

    private int zigZag(List<Integer> ls, int i) {
        int f = ls.get(i);
        int sec = ls.get(i + 1);
        int th = ls.get(i + 2);
        if ((f < sec && sec < th) || (f > sec && sec > th)) {
            return sec > f ? 1 : -1;
        } else {
            return 0;
        }
    }

    private List<Integer> getList(int[] arr) {
        List<Integer> ls = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            ls.add(arr[i]);
        }
        return ls;
    }

    private void run() throws Exception {
        configInput();
        configOutput();
        int t = getInt();
        solve(0);
        br.close();
        out.close();
    }

    private void configOutput() {
        File file = new File(OUT);
        if (file.exists()) {
            file.delete();
        }
        try {
            out = new PrintWriter(new File(OUT));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void configInput() {
        // TODO Auto-generated method stub
        try {
            //FileReader fr = new FileReader(IN);
            //br = new BufferedReader(fr);
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws Exception {
        new ZigZag().run();
    }

    public void pl(Object inp) {
        System.out.println(inp);
    }

    public void p(Object inp) {
        System.out.print(inp);
    }

    public void fpl(Object inp) {
        out.println(inp);
    }

    public void fp(Object inp) {
        out.print(inp);
    }

    public int getInt() throws NumberFormatException, IOException {
        return Integer.valueOf(br.readLine());
    }

    public int getInt(String i) {
        return Integer.valueOf(i);
    }

    public int[] sarr2IntArr() throws IOException {
        String[] arr = br.readLine().split("\\s+");
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = getInt(arr[i]);
        }

        return a;
    }

    public long[] sarr2LongArr() throws IOException {
        String[] arr = br.readLine().split("\\s+");
        long[] a = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = getLong(arr[i]);
        }

        return a;
    }

    public long getLong(String i) {
        return Long.valueOf(i);
    }

    public long getLong() throws NumberFormatException, IOException {
        return Long.valueOf(br.readLine());
    }

    public double getDouble() throws NumberFormatException, IOException {
        return Double.valueOf(br.readLine());
    }

    public long max(int a, int b) {
        return Math.max(a, b);
    }

    public long min(int a, int b) {
        return Math.min(a, b);
    }

    public int[] copyArray(int[] a) {
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }
        return arr;
    }

    public int intFromChar(char c) {
        return Character.getNumericValue(c);
    }
}

