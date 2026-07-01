class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int prev=nums[0];
        int curr=nums[0];
        int p=1;
        int max=nums[0];
        //approach find- min window sum , max window sum speartely compre which one is more in absolute from return that
        while(p<nums.length){
            curr=nums[p];
            if(curr+prev>curr){
                prev=curr+prev;
            }
            else{
                prev=curr;
            }
            max=Math.max(max,prev);
            p+=1;
        }
        prev=nums[0];
        curr=nums[0];
        p=1;
        int min=nums[0];
        while(p<nums.length){
            curr=nums[p];
            if(curr+prev<curr){
                prev=curr+prev;
            }
            else{
                prev=curr;
            }
            min=Math.min(min,prev);
            p+=1;
        }
       return Math.max(Math.abs(max),Math.abs(min));
    }
}