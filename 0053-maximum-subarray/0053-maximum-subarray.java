class Solution {
    public int maxSubArray(int[] nums) {
     int max =nums[0];
     int prev_sum=0;
     int curr=nums[0];
     int pointer=0;
     while(pointer<nums.length){
        curr=nums[pointer];
        if(prev_sum+curr>curr){
            prev_sum=prev_sum+curr;
        }
        else{
            prev_sum=curr;
        }
        max=Math.max(prev_sum,max);
        pointer+=1;
     }      
     return max;

    }
}