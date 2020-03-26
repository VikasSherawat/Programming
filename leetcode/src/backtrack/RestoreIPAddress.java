package backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    List<String> ls = new ArrayList<>();

    public static void main(String[] args) {
        List<String> ans = new RestoreIPAddress().restoreIpAddresses1("010010");
        ans.forEach(System.out::println);
    }
    public List<String> restoreIpAddresses(String s) {
        bt(s,0,0, "");
        return ls;
    }

    public List<String> restoreIpAddresses1(String s) {
        List<String> ret = new ArrayList<>();

        StringBuffer ip = new StringBuffer();
        for(int a = 1 ; a < 4 ; ++ a)
            for(int b = 1 ; b < 4 ; ++ b)
                for(int c = 1 ; c < 4 ; ++ c)
                    for(int d = 1 ; d < 4 ; ++ d)
                    {
                        if(a + b + c + d == s.length() )
                        {
                            int n1 = Integer.parseInt(s.substring(0, a));
                            int n2 = Integer.parseInt(s.substring(a, a+b));
                            int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
                            int n4 = Integer.parseInt(s.substring(a+b+c));
                            if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255)
                            {
                                ip.append(n1).append('.').append(n2)
                                        .append('.').append(n3).append('.').append(n4);
                                if(ip.length() == s.length() + 3) ret.add(ip.toString());
                                ip.delete(0, ip.length());
                            }
                        }
                    }
        return ret;
    }

    private void bt(String s, int i, int dec, String str){
        if(dec == 4 && i == s.length()){
            ls.add(str.substring(0,str.length()-1));
            return;
        }

        if(dec>3 || i>=s.length()){
            return ;
        }

        for(int j =i;j<i+3;j++){
            if(j-i>=3 || j+1 >s.length()){
                return;
            }

            String sub = s.substring(i,j+1);
            if(Integer.parseInt(sub)>255) continue;

            bt(s, j+1,dec+1,str+sub+".");
        }
    }
}
