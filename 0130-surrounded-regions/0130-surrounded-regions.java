class Solution {
    public void dfs(char[][] board,int row ,int col){
       board[row][col]='#';
       //upper 
       if(row-1>=0 && board[row-1][col]=='O'){
         dfs(board,row-1,col);
       }
       //down
        if(row+1<board.length && board[row+1][col]=='O'){
         dfs(board,row+1,col);
       }
       //left
        if(col-1>=0 && board[row][col-1]=='O'){
         dfs(board,row,col-1);
       }
       //right
         if(col+1<board[row].length && board[row][col+1]=='O'){
         dfs(board,row,col+1);
       }
      return;
    }  
    public void solve(char[][] board) {
        int row,col;
        row=0;
        for (col=0;col<board[row].length;col++){
          if(board[row][col]=='O'){
            dfs(board,row,col);
          }      
        }
        row=board.length-1;
        for (col=0;col<board[row].length;col++){
          if(board[row][col]=='O'){
            dfs(board,row,col);
          }      
        }
        col=0;
        for(row=0;row<board.length;row++){
          if(board[row][col]=='O'){
            dfs(board,row,col);
          }           
        }
        col=board[0].length-1;
         for(row=0;row<board.length;row++){
          if(board[row][col]=='O'){
            dfs(board,row,col);
          }           
        }
        for(row=0;row<board.length;row++){
            for(col=0;col<board[row].length;col++){
                if(board[row][col]=='O'){
                    board[row][col]='X';
                }  
                else if(board[row][col]=='#'){
                    board[row][col]='O';
                }            
            }
        }
        return ;
    }
}