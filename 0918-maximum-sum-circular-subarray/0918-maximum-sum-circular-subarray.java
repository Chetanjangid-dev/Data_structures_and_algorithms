class Solution {
    public int maxSubarraySumCircular(int[] nums) {
     int prev=nums[0];
     int curr=prev;
     int p=1;
     int max=nums[0];
     int min=nums[0];
     int totalsum=nums[0];
     while(p<nums.length){
        curr=nums[p];
        if(curr+prev>curr){
            prev=curr+prev;
        }
        else{
            prev=curr;
        }
        totalsum+=nums[p];
        max=Math.max(prev,max);
        p+=1;
     }
     if(max<0){
        return max;
     }
     prev=nums[0];
     p=1;
     curr=prev;
      while(p<nums.length){
        curr=nums[p];
        if(curr+prev<curr){
            prev=curr+prev;
        }
        else{
            prev=curr;
        }
        min=Math.min(prev,min);
        p+=1;
     }
     return Math.max(totalsum-min,max);
    }
}