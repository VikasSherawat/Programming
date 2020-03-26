package array;

import java.util.ArrayList;
import java.util.List;

public class JumpGame {
    public static void main(String[] args) {
        int[] n = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(new JumpGame().canJump(n));
    }
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }


}
