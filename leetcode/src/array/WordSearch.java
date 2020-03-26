package array;

public class WordSearch {
    /**
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     */
    public static void main(String[] args) {
        char[][] arr = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String w = "ESEEDASABFCC";
        System.out.println(new WordSearch().exist(arr,w));
    }
    public boolean exist(char[][] board, String word) {
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0) && check(board, word, i,j,0))
                    return true;
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int r, int c, int k){
        if(c<0 || r<0 || r>=board.length || c>=board[0].length || k>=word.length() || board[r][c]!=word.charAt(k)){
            return false;
        }
        char ch = board[r][c];
        board[r][c]='*';
        if(k==word.length()-1){
            return true;
        }
        boolean res = check(board,word,r+1,c,k+1);
        res = res || check(board,word,r,c+1,k+1);
        res = res || check(board,word,r-1,c,k+1);
        res = res || check(board,word,r,c-1,k+1);
        board[r][c]=ch;
        return res;
    }
}
