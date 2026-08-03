class Solution {
    int[] prices;
    int[][][] dp;
    public int rec(int index,int buyed,int k){
        if(k<=0 || index==prices.length){
            return 0;
        }
        //not buyed can choose buy or not
        int buy=0;
        int notbuy=0;
        if(dp[index][buyed][k]!=-1){
            return dp[index][buyed][k];
        }
        if(buyed==0){
           buy=rec(index+1,1,k)-prices[index];
           notbuy=rec(index+1,0,k);
           return  dp[index][buyed][k]=Math.max(buy,notbuy);
        }
        else{
        // sell or not sell
         return dp[index][buyed][k] = Math.max(prices[index]+rec(index+1,0,k-1),rec(index+1,buyed,k));
        }
    }
    public int maxProfit(int k,int[] prices) {
        this.prices=prices;
        dp=new int[prices.length+1][2][k+1];      //dp[index][buy]; 
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return rec(0,0,k);

    }
}