package divideAndConqure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParenthesis {
    Map<String, List<Integer>> cache = new HashMap<>();
    Map<String, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        List<Integer> ans = new DifferentWaysToAddParenthesis().diffWaysToCompute("2*3-4*5");
        System.out.println(Arrays.toString(ans.toArray()));
    }
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                String left = input.substring(0,i);
                String right = input.substring(i+1);

                List<Integer> leftResult = cache.get(left);
                if(leftResult == null){
                    leftResult = diffWaysToCompute(left);
                }else{
                    System.out.println("Cache hit");
                }
                List<Integer> rightResult = cache.get(right);
                if(rightResult == null){
                    rightResult = diffWaysToCompute(right);
                }else{
                    System.out.println("Cache hit");
                }

                for(int a: leftResult){
                    for(int b: rightResult){
                        int ans =0;
                        switch (c){
                            case '+':
                                ans = a+b;
                                break;
                            case '*':
                                ans = a*b;
                                break;
                            default: // case '-'
                                ans = a-b;
                                break;
                        }
                        res.add(ans);
                    }
                }
            }
        }

        if(res.size()==0){
            res.add(Integer.valueOf(input));
        }
        cache.put(input,res);
        return res;
    }
}
