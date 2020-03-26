package array;

public class SearchMatrix {

    //search space prune method
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0, j= col-1;i<row && j>=0;){
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(new SearchMatrix().searchMatrix(m,262));
    }

    int[][] mat;
    int num;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0){
            return false;
        }
        mat = matrix;
        num  = target;
        return search(0,0,matrix.length-1,matrix[0].length-1);
    }

    private boolean search(int top, int left, int bottom, int right){
        if(top>bottom || left>right){
            return false;
        }

        if(num<mat[top][left] || num>mat[bottom][right]) return false;
        if (bottom - top < 2 && right - left < 2) {
            return mat[top][left]==num || mat[top][right] == num ||
                    mat[bottom][left]==num || mat[bottom][right]==num;
        }else {
            int midV = left + (right-left)/2;
            int midH = top + (bottom-top)/2;
            return search(top, left, midH, midV) || search(top, midV+1,midH,right)||
                    search(midH+1,left,bottom,midV) || search(midH+1,midV+1,bottom,right);
        }
    }
}
