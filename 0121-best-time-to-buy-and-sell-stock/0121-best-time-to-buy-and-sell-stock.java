class Solution {
    int[] prices;
    int[][] dp;
    public int rec(int index,int buyed){
        if(index==prices.length){
            return 0;
        }
        //not buyed can choose buy or not
        int buy=0;
        int notbuy=0;
        if(dp[index][buyed]!=-1){
            return dp[index][buyed];
        }
        if(buyed==0){
           buy=rec(index+1,1)-prices[index];
           notbuy=rec(index+1,0);
           return dp[index][buyed] = Math.max(buy,notbuy);
        }
        else{
        // sell or not sell
         return dp[index][buyed]=Math.max(prices[index],rec(index+1,buyed));
        }
    }
    public int maxProfit(int[] prices) {
        this.prices=prices;
        dp=new int[prices.length+1][2];      //dp[index][buy]; 
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(0,0);
    }
}