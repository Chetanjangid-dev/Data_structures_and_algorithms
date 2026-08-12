class Solution {
    char[][] board;
    String word;
    public boolean dfs(int row,int col,int pointer){
        if(pointer==word.length()){
            return true;
        }
        char temp=board[row][col];
        board[row][col]='#';
        boolean up=false,down=false,left=false,right=false;
        //up
        if(row-1>=0 && board[row-1][col]==word.charAt(pointer)){
            up= dfs(row-1,col,pointer+1);
        }
        //down
        if(row+1<board.length && board[row+1][col]==word.charAt(pointer)){
             down= dfs(row+1,col,pointer+1);
        }
        if(col-1>=0 && board[row][col-1]==word.charAt(pointer)){
            left= dfs(row,col-1,pointer+1);
        }
        if(col+1<board[0].length && board[row][col+1]==word.charAt(pointer)){
            right= dfs(row,col+1,pointer+1);
        }
        board[row][col]=temp;
        return up||down||left||right;
    }
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.word=word;
        for(int row = 0; row<board.length;row++){
            for(int col = 0; col<board[0].length;col++){
                if(board[row][col]==word.charAt(0)){
                   if( dfs(row ,col,1)){
                    return true;
                   }
                }
            }
        }
      return false;
    }
}