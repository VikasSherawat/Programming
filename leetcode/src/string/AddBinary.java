package string;

public class AddBinary {
    public static void main(String[] args) {
        String a = "111", b = "111";
        //String ans= new AddBinary().addBinary(a,b);
        System.out.println(Character.isAlphabetic(' '));
    }
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1, carry =0;
        while(i>=0 || j>=0){

            int ic = i < 0 ? 0 : a.charAt(i--) - '0';
            int jc = j < 0 ? 0 : b.charAt(j--) - '0';
            int sum = ic+jc+carry;
            if(sum>1){
                sum -=2;
                carry =1;
            }else{
              carry = 0;
            }
            sb.insert(0,sum);
        }
        if(carry>0){
            sb.insert(0,1);
        }
        return sb.toString();
    }
}
