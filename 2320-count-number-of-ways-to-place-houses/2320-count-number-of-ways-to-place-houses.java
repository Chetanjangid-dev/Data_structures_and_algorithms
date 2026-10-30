class Solution {
    int n;
    int[] dp;
    int mod = 1000000000+7;
    public int countHousePlacements(int n) {
        this.n=n;       
        this.dp =  new int[(n*2) +2];
        dp[n*2]=1;
        dp[n*2+1]=1;
        for(int i = (n*2)-1;i>=0;i--){
            int skip = dp[i+1];
            int put=0;
            if(i+1 == n){
                put = dp[i+1];
            }
            else{
                put = dp[i+2];
            }
            dp[i] = (int)((long)put + skip)%mod;
        }
        return dp[0];
    }
}