class Solution {
    public int pivotIndex(int[] nums) {
        // total sum
        int sum=0;
        for(int i=0;i<nums.length;i++){
         sum +=nums[i];
        }
        int prefix_sum=0;
        int curr;
        for(int i=0;i<nums.length;i++){
           curr=nums[i];
           if(sum-prefix_sum-curr == prefix_sum){
            return i;
           }
           prefix_sum+=nums[i];
        }
       return -1;
    }
}