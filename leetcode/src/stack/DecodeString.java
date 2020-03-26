package stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<String> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            String c = s.substring(i,i+1);
            if(c.equals("]")){
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty()){
                    String cc = st.pop();
                    if(cc.equals("[")){
                        break;
                    }else{
                        sb.insert(0,cc);
                    }
                }
                int n = Integer.parseInt(st.pop());
                if(st.isEmpty()){
                    for(int j = 0;j<n;j++){
                        ans.append(sb);
                    }
                }else{
                    StringBuilder temp = new StringBuilder();
                    for(int j = 0;j<n;j++){
                        temp.append(sb);
                    }
                    st.push(temp.toString());
                }
            }else{
                st.push(c);
            }
        }
        StringBuilder temp = new StringBuilder();
            while(!st.isEmpty()){
                temp.insert(0,st.pop());
            }
        return ans.append(temp).toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        String ans= new DecodeString().decodeString(s);
        System.out.println(ans);
    }
}
