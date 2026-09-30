class Solution {

    boolean[][] dp ;
    public String longestPalindrome(String s) {     
       this.dp =  new boolean[s.length()+1][s.length()+1];
        int start = -1;
        int end = -1;
           int max = 0;
       for(int strlen = 1;strlen<=s.length();strlen++){
         for(int i = 0;i<=s.length()-strlen;i++){
             int j =strlen+i-1;
             if(strlen==1){dp[i][j]=true;}
             else if(strlen==2){
                 dp[i][j] = s.charAt(i)==s.charAt(j);
             }
             else{
                dp[i][j]=(dp[i+1][j-1] && s.charAt(i)==s.charAt(j));
             }
             if(dp[i][j]){
              if(j-i+1>max){
                  start = i;
                  end = j+1;
                  max = j-i+1; 
              } 
             }
           }
        }
        return s.substring(start,end);
    }

}