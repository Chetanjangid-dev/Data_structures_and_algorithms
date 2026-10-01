class Solution {
    public int countBinarySubstrings(String s) {
      int first=0;
      int second =0;
      int prev= 0 ;
      int curr = 0;
      int ans= 0;
      while(second<s.length()){
        while(second<s.length() && s.charAt(first) == s.charAt(second)){
            second++;
        }
        curr = second -first;
        ans += Math.min(prev,curr);
        prev = curr;
        first  = second;
      } 
      return ans;
    }
}