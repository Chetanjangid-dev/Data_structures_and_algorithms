class Solution {
    public int count(int k ,int[] nums){
      int first=0;
      int second=0;
      int sum=0;
      int count=0;
      while(second<nums.length){ 
       sum+=nums[second];
       while(first<=second && sum > k){
         sum-=nums[first];
         first+=1;
       }
       count+=second-first+1;
       second+=1;
      }  
     return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
      return count(goal,nums)-count(goal-1,nums);       
    }
}