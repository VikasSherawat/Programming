package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Asteroid {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> ls = new Stack<>();
        for(int n: asteroids){
            if(n>0){
                ls.push(n);
            }else{
                if(ls.isEmpty()){
                    ls.push(n);
                }else {
                    while(true) {
                        if (ls.isEmpty() || ls.peek() < 0) {
                            ls.push(n);
                            break;
                        } else {
                            int top = ls.peek();
                            if (n + top == 0) {
                                ls.pop();
                                break;
                            }else if(n+top<0){
                                ls.pop();
                            }else{
                                break;
                            }
                        }
                    }
                }
            }
        }
        int[] op = new int[ls.size()];
        int i =0;
        while(!ls.isEmpty()){
            op[i++]=ls.remove(0);
        }

        return op;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,-4};
        System.out.println(Arrays.toString(new Asteroid().asteroidCollision(a)));
    }


}
