class Solution {
    int[] dp;
    public int fibonacci(int n ){
      // base condtion
      if(n==0 || n==1){return n;}
      if(dp[n]!=0){
         return dp[n];
      }
      int ans= fibonacci(n-1)+fibonacci(n-2);
      dp[n]=ans;
      return ans;
    }
    public int fib(int n) {
       dp=new int[n+1];
       return  fibonacci(n);
    }
}