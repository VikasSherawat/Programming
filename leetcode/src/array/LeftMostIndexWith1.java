package array;

public class LeftMostIndexWith1 {
    /*
    In a binary matrix (all elements are 0 and 1), every row is sorted in ascending order
     (0 to the left of 1). Find the leftmost column index with a 1 in it.
     Input:
        [[0, 0, 0, 1],
         [0, 0, 1, 1],
         [0, 1, 1, 1],
         [0, 0, 0, 0]]
    Output:1
     */
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        System.out.println(new LeftMostIndexWith1().searchMatrix(arr,1));
        System.out.println((2)>>>1);
    }

    public int searchMatrix(int[][] m, int t) {
        if(m==null || m.length==0)  return -1;

        int r = m.length, c = m[0].length;
        int i =0, j=c-1, index =-1;
        while(i<r && j>=0){
            if(m[i][j]==1) {
                index =j;
                --j;
            }else{
                i++;
            }
        }

        return index;
    }
}
