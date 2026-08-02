class Solution {
    int[] nums;
    int[][] dp;
    public int rec(int index,int prev){
        if(index==nums.length){
            return 0;
        }
        if(prev !=-1 && dp[index][prev]!=-1){
            return dp[index][prev];
        }
        int take=0;
        int skip=0;
        if(prev==-1 || nums[prev]<nums[index]){
           //take 
           take=1+rec(index+1,index);
        }
        //take tb hi le skte jb ccurrent lement sseq ko todena but is contion me hum take and skip dono choose kr skte h //but agr curr seq tod rha to only skip
        //can only skip
        skip=rec(index+1,prev);
        if(prev==-1){
            return Math.max(take,skip);
        }
        dp[index][prev]=Math.max(take,skip);
        return dp[index][prev];
    }
    public int lengthOfLIS(int[] nums) {
        this.nums=nums;
        dp=new int[nums.length+1][nums.length+1];
        for(int i=0;i<nums.length;i++){ Arrays.fill(dp[i],-1);}
        return rec(0,-1);
        }
}