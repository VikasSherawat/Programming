package string;

public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("-91283472332"));
    }
    public int myAtoi(String str) {
        long a = Integer.MAX_VALUE;
        long b = Integer.MIN_VALUE;
        int ans = 0;
        boolean isNeg= false,valid = true;
        int start =-1, len =0;
        int j =0;
        while(str.charAt(j)==' '){
            j++;
        }
        str = str.substring(j);
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='-'){
                isNeg=true;
            }else{
                if(Character.isDigit(c)){
                    len++;
                    if(start==-1)
                        start =i;
                }else{
                    if(start==-1)
                        return 0;
                    else{
                        break;
                    }
                }
            }
        }
        String s = str.substring(start,start+len);
        int slen = s.length();
        long num = 0;
        for(int i = slen-1;i>=0;i--){
            num += (int)Math.pow(10,slen-i-1)*(s.charAt(i)-'0');
        }
        if(isNeg){
            num = -num;
        }

        if(num>a){
            num = a;
        }else if(num<b){
            num = b;
        }
        return (int)num;
    }}
