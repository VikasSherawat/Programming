package dp;

public class IsSubsequence {
    public static void main(String[] args) {
        boolean ans = new IsSubsequence().isSubsequence("aec","abcde");
        System.out.println(ans);
    }
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        if(s.length()>t.length()){
            return false;
        }
        if(s.length()==0)
            return true;
        for(int i = 0;i<t.length();i++){
            char sc = s.charAt(j);
            char tc = t.charAt(i);

            if(sc==tc){
                j++;
            }else{
                continue;
            }

            if(j==s.length()){
                return true;
            }
        }

        return false;
    }
}
