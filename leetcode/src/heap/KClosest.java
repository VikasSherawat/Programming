package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import sun.jvm.hotspot.utilities.Interval;

public class KClosest {
        /*
        We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
        (Here, the distance between two points on a plane is the Euclidean distance.)
        You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
         */

    public static void main(String[] args) {
        int[][] p = {{1,3},{-2,2}};
        p = new KClosest().kClosestUsingSort(p,1);
        for(int[] arr:p)
            System.out.println(Arrays.toString(arr));
    }

    public int[][] kClosestUsingSort(int[][] points, int k){
        Arrays.sort(points,  Comparator.comparingInt(a -> a[0] * a[0] + a[1] * a[1]));
        return Arrays.copyOf(points,k);
    }

    public int[][] kClosestUsingHeap(int[][] points, int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> ((b[0] * b[0]) + (b[1] * b[1])) - ((a[0] * a[0]) + (a[1] * a[1])));
        for(int[] arr: points){
            pq.add(arr);

            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] out = new int[k][2];
        int i =0;
        while(!pq.isEmpty()){
            out[i++]=pq.poll();
        }
        return out;
    }

    //kClosest using quick select
    public int[][] kClosest(int[][] points, int k) {
        Interval[] iv = new Interval[points.length];
        int count =0;
        for(int[] a: points){
            iv[count++]=new Interval(a[0],a[1]);
        }

        quickSelect(iv,0,iv.length-1,k) ;
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++){
            res[i][0]=iv[i].x;
            res[i][1]=iv[i].y;
        }
        return res;

    }

    private void quickSelect(Interval[] arr, int lo, int hi, int k){
        Interval res = arr[lo];
        if(lo<hi){
            int p = part(arr,lo,hi);
            if(p==k){
                return ;
            }else if(k<p){
                quickSelect(arr,lo,p-1,k);
            }else{
                quickSelect(arr,p+1,hi,k);
            }
        }
    }

    private int part(Interval[] arr, int lo, int hi){
        Interval p = arr[hi];
        int i = lo-1;
        for(int j = lo;j<=hi-1;j++){
            Interval cur = arr[j];
            if((cur.x*cur.x+cur.y*cur.y)<(p.x*p.x+p.y*p.y)){
                i++;
                swap(arr,i,j);
            }
        }

        swap(arr, i+1,hi);
        return i+1;
    }

    private void swap(Interval[] arr, int i, int j){
        Interval temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
    }
    private class Interval{
        int x;
        int y;

        public Interval(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}


