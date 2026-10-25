class Solution {
    int[] coins;
    int[][] dp;
    long recurse(int index , int amount){
      if(amount ==  0){
        return 0;
      }
      if(dp[index][amount] != -1) return dp[index][amount];
      int max = Integer.MAX_VALUE;
      long curr =max;
     
      long next = max;
      //choose curr
     if(amount  - coins[index] >= 0 )
      curr = 1 + recurse(index , amount - coins[index]);
    
     if(index+1<coins.length)
      next =  recurse(index+1,amount);
     return dp[index][amount] =(int) Math.min(curr,next);
    }
    public int coinChange(int[] coins, int amount) {
      this.coins=coins;
      this.dp = new int[coins.length+1][amount+1];
      for(int  i = 0;i<dp.length;i++){
        Arrays.fill(dp[i],-1);
      }
      long res = recurse(0,amount);
      if(res>= Integer.MAX_VALUE)  return -1;
      return (int)res;
    }
}