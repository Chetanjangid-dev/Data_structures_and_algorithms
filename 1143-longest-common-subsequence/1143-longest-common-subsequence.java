class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp=new int[text2.length()+1];
        for(int j=0;j<=text2.length();j++){
            dp[j]=0;
        }
        int[] copy;
        for(int i=text1.length()-1;i>=0;i--){
             copy=dp.clone();
             for(int j=text2.length()-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                   dp[j]=1+copy[j+1];//kyuki copy laready i+1 me h  
                }
                else{
                   dp[j]=Math.max(copy[j],dp[j+1]);//dp me by deault i=i  h and copy me i=i+1
                }
             }
        }
        return dp[0];
    }
}