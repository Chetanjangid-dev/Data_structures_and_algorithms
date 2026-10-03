class Solution {
    int[][] grid;
    int[][] dp ;
    int move(int i,int j ){
        if(i==grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        //2 options either down or right
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right  = Integer.MAX_VALUE;
        int down  = Integer.MAX_VALUE;
        if(i+1<grid.length){
            down = move(i+1,j);
        }
        if(j+1<grid[0].length){
            right = move(i,j+1);
        }
        return dp[i][j]=grid[i][j] + Math.min(down,right);
    }
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        this.dp = new int[grid.length][grid[0].length];
        for(int  i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return move(0,0);
    }
}