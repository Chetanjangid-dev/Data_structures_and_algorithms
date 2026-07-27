class Solution {
    int[] nums;
    int[] dp;
    public int choose(int index){
      if(index==nums.length-1){
       return nums[index];
      }
      if(index>=nums.length){
        return 0;
      }
      if(dp[index]!=-1){
        return dp[index];
      }
      //choose even
        int curr_choice=nums[index];
        int even_choice = choose(index+2);
        int odd_choice = choose(index+3);
        int ans=curr_choice+Math.max(even_choice,odd_choice);
        dp[index]=ans;
        return ans;   
    }
    public int rob(int[] nums) {
        this.nums=nums;
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        if(nums.length==0){return 0;}
        if(nums.length==1){return nums[0];}
        return Math.max(choose(0),choose(1)); 
    }
}