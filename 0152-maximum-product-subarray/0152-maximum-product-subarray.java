class Solution {
    public int maxProduct(int[] nums) {
        int prev_min=nums[0];
        int prev_max=nums[0];
        int curr=nums[0];
        int p=1;
        int max=nums[0];
        while(p<nums.length){
            curr=nums[p];
            int temp=prev_max;
            prev_max=Math.max(curr,Math.max(curr*prev_min,curr*prev_max));
            prev_min=Math.min(curr,Math.min(curr*prev_min,curr*temp));
            max=Math.max(max,prev_max);
            p+=1;
        }
        return max;
    }
}