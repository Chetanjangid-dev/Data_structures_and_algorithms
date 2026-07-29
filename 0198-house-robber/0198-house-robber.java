class Solution {
    public int rob(int[] nums) {
     int prev_prev = 0;
     int prev=nums[nums.length-1];
     int curr=nums[0];
     for(int i=nums.length-2;i>=0;i--){
        curr=Math.max(nums[i]+prev_prev,prev);
        prev_prev=prev;
        prev=curr;
     }
     return curr;
    }
}