package string;

public class MinRemoveToMakeStringValid {
    /*
    Given a string s of '(' , ')' and lowercase English characters.

    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

    Formally, a parentheses string is valid if and only if:

    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.
    s = "lee(t(c)o)de)" ->output =  "lee(t(c)o)de"
     */

    public static void main(String[] args) {
        String s = "(lee(t(c)o)(d(e)";
        String ans = new MinRemoveToMakeStringValid().minRemoveToMakeValid(s);
        System.out.println(ans);
    }

    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return s;
        char[] arr = s.toCharArray();
        int bal =0;
        for(int i =0;i<arr.length;i++){
            char c = arr[i];
            if(c == '('){
                bal++;
            }else if(c == ')'){
                if(bal == 0){
                    arr[i]='*';
                }else{
                    --bal;
                }
            }
        }

        int i = s.length()-1;
        while(bal>0){
            char c = arr[i];
            if(c == '('){
                arr[i]='*';
                --bal;
            }
            --i;
        }
        StringBuilder sb = new StringBuilder();
        for(char c: arr){
            if(c!='*'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
