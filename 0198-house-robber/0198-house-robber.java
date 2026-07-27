class Solution {
    int[] nums;
    int[] dp;
    public int choose(int index){
       if(index==nums.length-1 || index==nums.length-2){
         return nums[index];
       }
       if(dp[index]!=-1){
        return dp[index];
       }
       int max=0;
       for(int i=index+2;i<nums.length;i++)
       {  
           int ans = nums[index]+choose(i);
           max=Math.max(ans,max);
        }
        dp[index]=max;
        return dp[index];
    }
    public int rob(int[] nums) {
        this.nums=nums;
        dp=new int[nums.length-1];
        Arrays.fill(dp,-1);
        if(nums.length==0){return 0;}
        if(nums.length==1){return nums[0];}
        return Math.max(choose(0),choose(1)); 
    }
}