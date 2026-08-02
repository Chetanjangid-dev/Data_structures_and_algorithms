class Solution {
    int[] nums;
    int[][] dp;
    public int rec(int index,int prev){
        if(index==nums.length){
            return 0;
        }
        if( dp[index][prev+1]!=-1){
            return dp[index][prev+1];
        }
        int take=0;
        int skip=0;
        if(prev==-1  ||  nums[prev]<nums[index]){
           //take 
           take=1+rec(index+1,index);
        }
        skip=rec(index+1,prev);
        dp[index][prev+1]=Math.max(take,skip);
        return dp[index][prev+1];
    }
    public int lengthOfLIS(int[] nums) {
        this.nums=nums;
        dp=new int[nums.length+1][nums.length+2];
        for(int i=0;i<dp.length;i++){ 
          Arrays.fill(dp[i],-1);
         }
        return rec(0,-1);
        }
    }