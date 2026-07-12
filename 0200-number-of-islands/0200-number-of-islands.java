class Solution {
    public void DFS(char[][] grid, int row, int col){
    // i will reach here when grid[row][col] is already 1
    // and here the orignaal grid will be modifeid means where we do '0' it will also  appears in orignal
    grid[row][col] = '0';    
    // up
    if(row - 1 >= 0 && grid[row - 1][col] != '0'){
        DFS(grid, row - 1, col);
    }
    // down
    if(row + 1 < grid.length && grid[row + 1][col] != '0'){
        DFS(grid, row + 1, col);
    }
    // left 
    if(col - 1 >= 0 && grid[row][col - 1] != '0'){
        DFS(grid, row, col - 1);
    }
    // right 
    if(col + 1 < grid[0].length && grid[row][col + 1] != '0'){
        DFS(grid, row, col + 1);
    }
    return;
    }
    public int numIslands(char[][] grid) {
     //visted 1s and 0 will be ignored 
     int islands=0;
     for (int row=0;row<grid.length;row++){
        for(int col=0;col<grid[row].length;col++){
         if(grid[row][col]=='1'){
           islands++;
           DFS(grid,row,col);
         }
        }
     }   
     return islands;
    }
}