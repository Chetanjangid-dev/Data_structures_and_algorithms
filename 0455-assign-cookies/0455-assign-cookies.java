class Solution {
    public int findContentChildren(int[] g, int[] s) {
      Arrays.sort(s);
      Arrays.sort(g);
      int greed  = g.length-1;
      int cookie =  s.length-1;
      int ans = 0 ;
      while(greed>=0 && cookie>=0){
        if(g[greed]<=s[cookie]){
             ans++;
             cookie--;     
        }
        greed--;
      }   
      return ans;
    }
}