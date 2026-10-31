class Solution {
    int max_product  = 0 ;
    int n;
    int[] dp;
   int recurse(int n ){
        if(n == 0 || n==1){
            return 1;
        }
        if(dp[n]!= -1){
            return dp[n];
        }
        int local_max = 0;
        for(int i = 1 ; i<=n;i++){
             local_max = Math.max(i*recurse(n-i) , local_max);
        }
        return dp[n]=local_max;
    }
    public int integerBreak(int n) {
        this.n=n;
        this.dp =  new int[n+1];
        Arrays.fill(dp,-1);
        int local_max= 0;
        for(int i =1 ;i<n;i++){
          local_max= Math.max(i*recurse(n-i) ,local_max);
        }
        dp[n] = local_max;
        return local_max;
    }
}