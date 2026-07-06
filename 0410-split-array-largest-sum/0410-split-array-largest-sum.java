class Solution {
    public int splitArray(int[] nums, int k) {
        long low=nums[0];
        long high=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>low){
                low=nums[i];
            }
            high+=nums[i];
        }
        while(low<high){
            long mid=low+(high-low)/2;
            int partition=0;
            long total=0;
            for(int i=0;i<nums.length;i++){
                if(total+nums[i]<=mid){
                    total+=nums[i];
                }
                else{
                    partition+=1;
                    total=nums[i];
                }
            }
            partition++;
            if(partition<=k){
              high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return (int)low;
    }
}