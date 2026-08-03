
class Solution {
    int[] prices;
    int[][][] dp;
    public int maxProfit(int[] prices) {
        int m,n,k;
        m=prices.length;
        n=2;
        k=2;
        dp=new int[m+1][n][k+1];      //dp[index][buy]; 
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                dp[m][i][j]=0;
            }
        }
        for(int i=0;i<=m;i++){
            for(int j= 0;j<n;j++){
                dp[i][j][0]=0;
            }
        }
        for(int index=dp.length-2;index>=0;index--){
            for(int buyed = 0; buyed<=1;buyed++){
               for(int j=1;j<=k;j++){
                if(buyed==0){
                   dp[index][buyed][j]=Math.max(dp[index+1][1][j]-prices[index],dp[index+1][0][j]);
                }   
                else{
                   dp[index][1][j]=Math.max(prices[index]+dp[index+1][0][j-1],dp[index+1][1][j]);
                } 
               }           
            }
        }
        return dp[0][0][k];
    }
}