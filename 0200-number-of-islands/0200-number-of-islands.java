class Solution {
    char[][] grid ;
    void DFS(int row ,int col){
        grid[row][col] ='0';
            // up
    if(row - 1 >= 0 && grid[row - 1][col] != '0'){
        DFS( row - 1, col);
    }
    // down
    if(row + 1 < grid.length && grid[row + 1][col] != '0'){
        DFS( row + 1, col);
    }
    // left 
    if(col - 1 >= 0 && grid[row][col - 1] != '0'){
        DFS( row, col - 1);
    }
    // right 
    if(col + 1 < grid[0].length && grid[row][col + 1] != '0'){
        DFS( row, col + 1);
    }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        this.grid = grid;  
        for(int  i = 0 ; i < grid.length ; i++){
            for(int  j = 0; j<grid[i].length ; j++){
               if(grid[i][j]=='1'){
                int row  = i;
                int col = j ;
                DFS(row,col);
                count++;
               }
        }
        }
        return count;
    }
}