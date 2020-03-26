package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    Set<String> dict = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        this.dict.addAll(wordDict);
        return helper(s, 0, new Boolean[s.length()]);
    }

    public boolean wordBreakDP(String s, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
    private boolean helper(String s, int start, Boolean[] dp){
        if(s.length()==start)
            return true;
        if(dp[start]!=null){
            return dp[start];
        }
        for(int i = start;i<s.length();i++){
            String sub = s.substring(start, i+1);
            if(this.dict.contains(sub) && helper(s, i+1, dp)){
                return dp[start]=true;
            }
        }
        return dp[start]=false;
    }
}
