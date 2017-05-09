package thirtyDaysChallenge;
import java.util.*;

public class Day25 {
    public static void main(String[] args){
Scanner in = new Scanner(System.in);
int T = in.nextInt();
String[] result =  new String[T];
int count=0;
while(T-->0){
   // long num = ;
	result[count++] = findPrime(in.nextLong());
}
for(int i=0;i<result.length;i++){
	System.out.println(result[i]);
}

}

static String findPrime(long num){
if(num<=1)
	return "Not prime";
else if(num<=3)
	return "Prime";
else if(num%2==0 || num%3==0)
	return "Not prime";
long count =5;
while(count*count<=num){
	if(num%count==0 || num%(count+2)==0)
		return "Not prime";
	count+=6;
}
return "Prime";

}
}
