class Solution {
    int[] prices;
    int n ;
    int[][] dp;
    public int maxProfit(int[] prices) {
              this.prices=prices;
              n = prices.length;
              this.dp = new int[n+1][2];
              for(int i = 0 ; i < dp.length ; i++){
                dp[i][0]=-1;
                dp[i][1]=-1;
              }
              return    rec(0,0);
    }
    int rec(int index ,  int buyed){
        if(index>=n){
            return 0;
        }
        if(dp[index][buyed]!=-1){
            return dp[index][buyed];
        }
        if(buyed==0){
            return dp[index][buyed] =  Math.max(rec(index+1,1) - prices[index] , rec(index+1,buyed));
        }
        else{
            return dp[index][buyed]= Math.max(rec(index+1,0) + prices[index] , rec(index+1,buyed));
        }
    }
}