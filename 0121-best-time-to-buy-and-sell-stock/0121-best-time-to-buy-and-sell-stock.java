class Solution {
    int[] prices;
    int[] dp;
    public int maxProfit(int[] prices) {
        this.prices=prices;
        dp=new int[2];      //dp[index][buy]; 
        dp[0]=0;
        dp[1]=0;
        int[] copy;
        for(int index=prices.length-1;index>=0;index--){
            copy=dp.clone();
            for(int buyed = 0; buyed<=1;buyed++){
                if(buyed==0){
                   dp[0]=Math.max((copy[1]-prices[index]),copy[0]);
                }   
                else{
                   dp[1]=Math.max(prices[index],copy[1]);
                }            
            }
        }
        return dp[0];//index=0 by deault and buyed=false
    }
}