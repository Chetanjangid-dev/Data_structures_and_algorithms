class Solution {
    
    int[] dp;
    public int rec(int n){
      if(n<0){
        return 0;}
      if(n==0){
        return 1;
      }
      int option1,option2;;
      // choose 1
       if(dp[n-1]!=0){
          option1=dp[n-1];
       }
       else{
         option1= rec(n-1);
         dp[n-1]=option1;
       }
       // choose 2
       if(n-2>=0 && dp[n-2]!=0){
          option2=dp[n-2];
       }
       else{
         option2= rec(n-2);
         if(n-2>=0){
         dp[n-2]=option2;}
       }
       return option1 + option2;      
    }
    public int climbStairs(int n) {
        dp=new int[n+1];
        return rec(n);
        
    }
}