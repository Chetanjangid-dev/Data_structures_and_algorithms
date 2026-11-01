class Solution {
    int[] dp;
    int count;
    int mod = 1000000007;
    int  recurse(int i){
     if( i == count){
        return 1;
     }
     if(dp[i]!=-1) return dp[i];
     int choose =0;
     int skip=0;
     choose = recurse(i+1);
     skip = recurse(i+1);
     return dp[i]= (choose + skip)  % mod;
    }
    public int countWays(int[][] ranges) {
      int count= 0;
       Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));
      int i = 0;
      while(i<ranges.length){
        int start = ranges[i][0];
        int end = ranges[i][1];
        while(i+1<ranges.length && end >= ranges[i+1][0] ){
            end =  Math.max(end , ranges[i+1][1]);
            i++;
        }
        count++;
        i++;
      }
      this.count = count;
      this.dp =  new int[count+1];
      Arrays.fill(dp,-1);   
      return recurse(count-count) % mod;
    }
}