package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> ls = new ArrayList<>();

    public static void main(String[] args) {
        List<String> ls = new GenerateParentheses().generateParenthesis(3);
        for(String s: ls){
            System.out.println(s);
        }
    }
    public List<String> generateParenthesis(int n) {
        bt(n-1, n, new StringBuilder("("));
        return ls;
    }

    private void bt(int left, int right, StringBuilder sb){
        if(left<0 || right <0){
            return;
        }

        if(left==0 && right==0){
            ls.add(sb.toString());
            return;
        }

        if(left==0 && right!=0){
            while(right!=0){
                sb.append(")");
                --right;
            }
            ls.add(sb.toString());
            return;
        }

        bt(left-1, right, new StringBuilder(sb.toString()+"("));
        if(right-1>=left)
            bt(left, right-1, new StringBuilder(sb.toString()+")"));
    }
}
