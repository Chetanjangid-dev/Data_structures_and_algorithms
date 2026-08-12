class Solution {
    char[][] board;
    String word;
    public boolean dfs(int row,int col,int pointer,boolean[][] visited){
        if(pointer==word.length()){
            return true;
        }
        visited[row][col]=true;
        boolean up=false,down=false,left=false,right=false;
        //up
        if(row-1>=0 && board[row-1][col]==word.charAt(pointer) && visited[row-1][col]==false ){
            up= dfs(row-1,col,pointer+1,visited);
        }
        //down
        if(row+1<board.length && board[row+1][col]==word.charAt(pointer) && visited[row+1][col]==false){
             down= dfs(row+1,col,pointer+1,visited);
        }
        if(col-1>=0 && board[row][col-1]==word.charAt(pointer) && visited[row][col-1]==false ){
            left= dfs(row,col-1,pointer+1,visited);
        }
        if(col+1<board[0].length && board[row][col+1]==word.charAt(pointer)  && visited[row][col+1]==false){
            right= dfs(row,col+1,pointer+1,visited);
        }
        visited[row][col]=false;
        return up||down||left||right;
    }
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.word=word;
         boolean[][] visited = new boolean[board.length][board[0].length];
        for(int row = 0; row<board.length;row++){
            for(int col = 0; col<board[0].length;col++){
                if(board[row][col]==word.charAt(0)){
                   if( dfs(row ,col,1,visited)){
                    return true;
                   }
                }
            }
        }
      return false;
    }
}