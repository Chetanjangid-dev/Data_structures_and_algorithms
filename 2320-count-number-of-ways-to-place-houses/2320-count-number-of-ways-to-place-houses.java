class Solution {
    int n;
    int[] dp;
    int mod = 1000000000+7;
    public int  ways(int i){
       if(i >= (n*2)){
        return 1;
       }
       if(dp[i] != -1){
        return dp[i];
       }
       int  put=0;
       int  skip=0;
       //put house on plot i
       if(i+1 == n){
        put = (ways(i+1) %mod); 
       }else{
        put =(ways(i+2) % mod);
       }
        //skip house on plot i
        skip  = (ways(i+1)%mod);
        return dp[i]=(put+skip)%mod;
    }
    public int countHousePlacements(int n) {
        this.dp =  new int[(n*2) +1];
        Arrays.fill(dp,-1);
        this.n=n;
        
        return   ways(0)%mod;
    }
}