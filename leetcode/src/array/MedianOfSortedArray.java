package array;

public class MedianOfSortedArray {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        double ans = new MedianOfSortedArray().findMedianSortedArrays(a,b);
        System.out.println(ans);
    }
    public double findMedianSortedArrays(int[] a, int[] b) {
        int al = a.length;
        int bl = b.length;
        if(al>bl)
            return findMedianSortedArrays(b,a);
        int start = 0, end = al;

        while(start<=end){
            int partX = (start+end)/2;
            int partY = (al+bl+1)/2-partX;

            int maxLeftX = partX == 0 ? Integer.MIN_VALUE:a[partX-1];
            int minRightX = partX == al ? Integer.MAX_VALUE:a[partX];

            int maxLeftY = partY == 0 ? Integer.MIN_VALUE:b[partY-1];
            int minRightY = partY == bl ? Integer.MAX_VALUE:b[partY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((al+bl)%2==0){
                    return (double)(Math.max(maxLeftX, maxLeftY)+Math.min( minRightX, minRightY))*0.5;
                }else{
                    return Math.max(maxLeftX, maxLeftY);
                }
            }else if(maxLeftX>minRightY){
                end = partX-1;
            }else{
                start = partX+1;
            }
        }

        return -1;
    }

}
