package stack;

import java.util.LinkedList;

public class RemoveAdjacent {
    public static void main(String[] args) {
        String ans = new RemoveAdjacent().removeAdjacent("deeedbbcccbdaa",3);
        System.out.println(ans);
    }
    public String removeDuplicates(String s, int k) {
        LinkedList<int[]> st = new LinkedList<>();
        for(char c: s.toCharArray()){
            int charInt = c-'a';
            if(st.isEmpty()){
                st.addLast(new int[]{charInt,1});
            }else{
                if(st.peekLast()[0]==charInt){
                    if(st.peekLast()[1]+1==k){
                        while(!st.isEmpty() && st.peekLast()[0]==charInt){
                            st.removeLast();
                        }
                    }else{
                        st.addLast(new int[]{charInt, st.peekLast()[1]+1});
                    }
                }else{
                    st.addLast(new int[]{charInt,1});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char c = (char)(st.removeFirst()[0]+'a');
            sb.append(c);
        }

        return sb.toString();
    }
    public String removeAdjacent(String s, int k){
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k){
                i -= k;
            }
        }
        return new String(stack, 0, i);
    }
}
