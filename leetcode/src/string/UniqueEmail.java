package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {
    public static void main(String[] args) {
        String[] arr = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        int ans = new UniqueEmail().numUniqueEmails(arr);
        System.out.println(ans);
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email: emails){
            String[] nameAndDomain = email.split("@");
            String[] splitOnPlus = nameAndDomain[0].split("\\+");
            String nameWithoutPeriod = splitOnPlus[0].replace(".","");
            set.add(nameWithoutPeriod+"@"+nameAndDomain[1]);
        }
        return set.size();

    }
}
