package array;

public class TrapRainWatre {

    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = new TrapRainWatre().trap(a);
        System.out.println(ans);
     }
    public int trap(int[] h) {
        int len= h.length, ans =0;
        if(len==0)
            return ans;

        int l = 0, r = len-1;
        int lmax = 0, rmax =0;

        while(l<r){
            if(h[l]>lmax){
                lmax = h[l];
            }

            if(h[r]>rmax){
                rmax = h[r];
            }

            if(lmax>rmax){
                ans += Math.max(0, rmax-h[r]);
                r--;
            }else{
                ans += Math.max(0, lmax-h[l]);
                l++;
            }
        }

        return ans;
    }
}
