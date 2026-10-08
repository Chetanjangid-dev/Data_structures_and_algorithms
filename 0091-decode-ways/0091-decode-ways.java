class Solution {
    String s ;
    int[] dp;
    int partition(int i){
     if(i==s.length()){
        return 1;
     }
     if(dp[i]!=-1) return dp[i];
     int one=0;
     int two = 0;
     //option1
     if(Integer.parseInt(s.charAt(i)+"")>0){
        one = partition(i+1);
     }
     if(i+1<s.length() && s.charAt(i)!='0' && Integer.parseInt(s.charAt(i) +""+s.charAt(i+1)) <27 &&  Integer.parseInt(s.charAt(i) +""+s.charAt(i+1)) >0 ){
       two=partition(i+2);     
      }
      return dp[i]=one+two;
     } 
    public int numDecodings(String s) {
         if(s.length()==0) return 0;
         this.s=s;
         this.dp=new int[s.length()+1];
         Arrays.fill(dp,-1);
         return partition(0);
    }
}