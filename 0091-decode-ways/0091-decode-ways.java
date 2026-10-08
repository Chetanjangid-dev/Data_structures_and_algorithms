class Solution {
    String s ;
    int[] dp;
    public int numDecodings(String s) {
         if(s.length()==0) return 0;
         this.s=s;
         this.dp=new int[s.length()+1];
         dp[s.length()]=  1;
         for(int i = s.length()-1;i>=0;i--){
            int one=0;
            int two=0;
            if(Integer.parseInt(s.charAt(i)+"")>0){
              one =dp[i+1];
            }
           if(i+1<s.length() && s.charAt(i)!='0' && Integer.parseInt(s.charAt(i) +""+s.charAt(i+1)) <27 &&  Integer.parseInt(s.  charAt  (i) +""+s.charAt(i+1)) >0 ){
            two=dp[i+2];     
           }
           dp[i]=one+two;
         }
         return dp[0];
    }
}