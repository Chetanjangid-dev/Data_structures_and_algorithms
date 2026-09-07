class Solution {
    String word;
    char[][] board ; 
    boolean dfs(int row,int col,int p){
       char original=board[row][col];
      board[row][col]='#';
    
      if(p>=word.length()){
        return true;
      }
      char ch = word.charAt(p);
      boolean left ,right ,top ,bottom;
      left=false;
      right=false;
      bottom=false;
      top=false;
      //top
      if(row-1>=0 && board[row-1][col]==ch){
       top =dfs(row-1,col,p+1);
      }
      //down
      if(row+1<board.length && board[row+1][col]==ch){
      bottom= dfs(row+1,col,p+1);
      }
      //left
     if(col-1>=0 && board[row][col-1]==ch){
      left= dfs(row,col-1,p+1);
      }
      //right
      if(col+1<board[0].length && board[row][col+1]==ch){
       right=dfs(row,col+1,p+1);
      }
      board[row][col] = original;
      return top||bottom||left||right;
    }   
    public boolean exist(char[][] board, String word) {
       int  p =  0;
       this.word=word;
       this.board=board;
       for(int row  = 0; row  < board.length ; row++){
          for(int col = 0 ; col <board[row].length ;col++){
             if(board[row][col] == word.charAt(p)){
               if (dfs(row,col,p+1)){
                return true;
               }
              }
          }
       } 
       return false;
    }
}