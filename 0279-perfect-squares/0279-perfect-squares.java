class Solution {
    int[] dp;
     int recurse(int n )
    {
       if(n == 0 || n == 1){
           return n ;
       }
    if(dp[n]!=-1) return dp[n];
    int local_min = Integer.MAX_VALUE;
    for(int  i = 1 ; i <= Math.sqrt(n);i++){
       local_min =  Math.min(recurse(n-(i*i)),local_min);
    }
    return dp[n]=local_min+1;
    }
    public int numSquares(int n) {
        this.dp =  new int[n+1];
        Arrays.fill(dp,-1);
        return recurse(n);
    }
}