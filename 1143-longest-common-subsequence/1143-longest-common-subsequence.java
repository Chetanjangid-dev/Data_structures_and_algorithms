class Solution {
    String text1;
    String text2;
    int[][] dp;
    public int lcs(int i ,int j){
        if(i==text1.length()){
            return 0;
        }
        if(j==text2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
            return 1 + lcs(i+1,j+1);
        }
        int move_i=0;
        int move_j=0;
        // else i wil have 2 options 
        //move i
        move_i=lcs(i+1,j);
        //move j
        move_j=lcs(i,j+1);
        dp[i][j]=Math.max(move_i,move_j);
        return dp[i][j];
        
    }
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1=text1;
        this.text2=text2;
        dp=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++){
           Arrays.fill(dp[i],-1);
        }
        return lcs(0,0);
    }
}