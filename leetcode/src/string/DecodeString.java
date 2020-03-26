package string;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(new DecodeString().decodeString(s));
    }
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<String> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ']'){
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty () && !st.peek().equals("[")){
                    sb.append(st.pop());
                }
                sb.reverse();
                StringBuilder num = new StringBuilder();
                int n =0;
                st.pop();
                while (!st.isEmpty()){
                    try {
                        num.append(Integer.valueOf(st.peek()));
                        st.pop();
                    }catch (Exception e){
                        break;
                    }finally {
                        n = Integer.parseInt(num.reverse().toString());
                    }
                }

                StringBuilder temp = new StringBuilder();
                while(n-->0){
                    temp.append(sb);
                }
                st.push(temp.toString());

            }else{
                st.push(s.substring(i,i+1));
            }

        }
        while(!st.isEmpty()){
            ans.insert(0,st.pop());
        }

        return ans.toString();
    }
}
