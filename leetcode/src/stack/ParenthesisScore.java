package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParenthesisScore {
    public static void main(String[] args) {
        String s = "(()(()()))";
        int ans = new ParenthesisScore().scoreOfParentheses(s);
        System.out.println(ans);
    }

    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                int n = 0;
                while (st.peek() != -1) {
                    n += st.pop();
                }
                st.pop();
                st.push(n==0?1:2 * n);
            } else {
                st.push(-1);
            }
        }
        int ans = 0;
        while (!st.isEmpty())
            ans += st.pop();
        return ans;
    }
}
