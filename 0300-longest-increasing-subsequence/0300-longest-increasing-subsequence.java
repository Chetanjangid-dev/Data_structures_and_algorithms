class Solution {
    int[] nums;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        this.nums=nums;
        dp=new int[nums.length+1][nums.length+2];
        for(int curr=dp.length-2;curr>=0;curr--){ 
          for(int prev =-1;prev<curr;prev++){
           int take=0;
           int skip=0;
           if(prev==-1 || nums[prev]<nums[curr]){
             take=1+dp[curr+1][curr+1];
           }
           skip=dp[curr+1][prev+1];
           dp[curr][prev+1]=Math.max(take,skip);
          }
         }
        return dp[0][0];
        }
    }