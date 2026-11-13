import java.util.Arrays;

class Solution {
    int[][] players;
    int[][] dp;
    int recurse(int i,int prev){
        if( i >= players.length){
            return 0;
        }
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int choose = 0;
        int skip  = 0;
        if(prev == -1 || (players[prev][1] <= players[i][1] )){
            choose = players[i][1] + recurse(i+1,i);
        }
        skip = recurse(i+1,prev);
        return dp[i][prev+1] = Math.max(choose,skip);
         
    }
    public int bestTeamScore(int[] scores, int[] ages) {
         this.players =  new int[scores.length][2];
         this.dp =  new int[players.length+1][players.length+2];
         for(int  i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
         }        
         for(int i = 0 ;i<ages.length;i++){
            int age = ages[i];
            int score = scores[i];
            players[i][0] = age;
            players[i][1] = score;
         }        
       Arrays.sort(players, (a, b) -> {
    if (a[0] != b[0]) {
        return Integer.compare(a[0], b[0]);
    }
    return Integer.compare(a[1], b[1]);
});
         return recurse(0,-1);
    }
}