class Solution {
    int n;
    int mod = 1000000000+7;
    public int countHousePlacements(int n) {
        this.n=n;       
        int prev = 1;
        int prev_of_prev = 1;
        for(int i = (n*2)-1;i>=0;i--){
            int skip =prev;
            int put=0;
            if(i+1 == n){
                put = prev;
            }
            else{
                put = prev_of_prev;
            }
            prev_of_prev = prev;
            prev= (int)((long)put + skip)%mod;
        }
        return prev;
    }
}