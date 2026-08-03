class Solution {
    int[] prices;
    int[][] dp;
    public int maxProfit(int[] prices) {
        this.prices=prices;
        dp=new int[prices.length+1][2];      //dp[index][buy]; 
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[dp.length-1],0);
        }
        for(int index=dp.length-2;index>=0;index--){
            for(int buyed = 0; buyed<=1;buyed++){
                if(buyed==0){
                  dp[index][buyed]=Math.max(dp[index+1][1]-prices[index],dp[index+1][0]);
                }   
                else{
                   dp[index][1]=Math.max(prices[index],dp[index+1][1]);
                }            
            }
        }
        return dp[0][0];
    }
}