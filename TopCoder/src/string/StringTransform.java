package string;

/**
 * Created by vikas on 9/5/17.
 */
public class StringTransform {
    public static void main(String[] args){
        String s = "madam";
        String t = "madam";
        System.out.println(new StringTransform().isPossible(s,t));
    }

    public String isPossible(String s, String t){
        if(s.length()!=t.length()){
            return "Impossible";
        }


        boolean flag = true;
        int len = s.length()-1;
        for (int i = len; i >0 ; i--) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(sc!=tc){
                int idx = s.indexOf(tc);
                if(!(idx>=0 && idx<i)){
                    flag = false;
                    break;
                }
            }
        }
        if(s.charAt(0)!=t.charAt(0))
            flag = false;

        return flag?"Possible":"Impossible";
    }
}
