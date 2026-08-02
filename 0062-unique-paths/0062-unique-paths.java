class Solution {
    int m,n;
    int[] dp;
    public int uniquePaths(int m, int n) {
     this.m=m;
     this.n=n;
     this.dp=new int[n];
     Arrays.fill(dp,1);
     int[] copy;
     for(int i=m-2;i>=0;i--)
     {
        copy=dp.clone();
        for(int j=n-2;j>=0;j--)
        {
         dp[j]=dp[j+1]+copy[j];
        }
     }
     return dp[0];       
    }
}