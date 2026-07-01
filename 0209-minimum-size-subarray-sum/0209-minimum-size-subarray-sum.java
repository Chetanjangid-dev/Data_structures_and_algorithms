class Solution {
    public int minSubArrayLen(int target, int[] nums) {
     int first=0;
     int second=first;
     int sum=0;
     int cs=0;
      int min = Integer.MAX_VALUE;
     while(first<=second && second<nums.length){
       sum+=nums[second];
       while(first<=second && sum>=target){
         min=Math.min(second-first+1,min);
         sum-=nums[first];
         first+=1;
       }
       second+=1;
     }
     if(min== Integer.MAX_VALUE){
        return 0;
     }
     return min;
    }
}