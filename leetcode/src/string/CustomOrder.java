package string;

public class CustomOrder {

    public static void main(String[] args) {
        String[] a = {"hello","leetcode"};
        String s = "hlabcdefgijkmnopqrstuvwxyz";
        boolean ans = new CustomOrder().isAlienSorted(a,s);
        System.out.println(ans);
    }
    public boolean isAlienSorted(String[] words, String order) {

        int[][] arr = new int[words.length][20];
        int i =0;
        int min = 101;
        for(String word: words){
            min = Math.min(min, word.length());
            for(int k =0;k<word.length();k++){
                arr[i][k]=order.indexOf(word.charAt(k));
            }
            i++;
        }

        double[] num = new double[arr.length];
        i = 0;
        for(int[] a: arr){
            double hash = 0.0;
            int j =0;
            for(int k = a.length-1;k>=0;k--){
                hash = hash + a[k]*Math.pow(10,j++);
            }
            num[i++]=hash;
        }

        for(int j = 1;j<num.length;j++){
            if(num[j]<num[j-1])
                return false;
        }


        return true;

    }
}
