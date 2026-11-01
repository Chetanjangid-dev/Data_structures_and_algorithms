class Solution {
    int[] dp;
    int count;
    int mod = 1000000007;

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
      int prev =1;
      for(i = count-1;i>=0;i--){
         prev = (2* prev)%mod;
      }     
      return prev%mod;
    }
}