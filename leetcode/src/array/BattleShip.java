package array;

public class BattleShip {
    public static void main(String[] args) {
        char[][] board = {
                {'*','*','.','.'},
                {'.','*','*','*'},
                {'.','*','.','*'}
        };
        int ans = new BattleShip().countBattleships(board);
        System.out.println(ans);
    }

    public int countBattleships(char[][] board) {
        int ans =0;

        for(int i =0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                char c = board[i][j];
                if(c=='.'){
                    continue;
                }
                if(validBattleShip(board, i, j)){
                    ans++;
                }

                dfs(board, i, j);

            }
        }

        return ans;
    }
    private void dfs(char[][] board, int row, int col){
        if(row<0 || col<0 || row>=board.length || col >=board[0].length || board[row][col]=='.'){
            return;
        }

        board[row][col]='.';
        dfs(board,row+1,col);
        dfs(board,row-1,col);
        dfs(board,row,col+1);
        dfs(board,row,col-1);
    }

    private boolean validBattleShip(char[][] board, int row, int col){
        while(row<board.length-1){
                if(board[row][col]=='*'){
                    if(col<board[0].length-1 && board[row][col+1]=='*'){
                        return false;
                    }
                    if(col>0 && board[row][col-1]=='*'){
                        return false;
                    }
                }else{
                    break;
                }
            row++;
        }

        return true;
    }


}
