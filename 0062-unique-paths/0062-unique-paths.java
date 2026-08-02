class Solution {
    int m,n;
    int[][] dp;
    public int move(int i,int j){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i==m){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(j==n){
            return 0;
        }
        int down=0;
        int right=0;
        //move down
        down=move(i+1,j);
        //move right
        right=move(i,j+1);
        return dp[i][j]=down+right;
    }
    public int uniquePaths(int m, int n) {
     this.m=m;
     this.n=n;
     dp=new int[m+1][n+1];
     for(int i=0;i<dp.length;i++)
     {
        Arrays.fill(dp[i],-1);
     }
     return move(0,0);       
    }
}