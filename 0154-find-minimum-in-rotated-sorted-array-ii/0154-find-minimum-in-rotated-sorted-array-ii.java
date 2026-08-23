class Solution {
    public int findMin(int[] nums) {
        int low,high,mid;
        low=0;
        high=nums.length-1;
        while(low<high){
          mid = (low+high)/2;
          if(mid<high && nums[mid]==nums[high]){
            high--;
            continue;
          }
          if(nums[mid]<nums[high]){
            high =  mid; 
          }
          else{
            low = mid+1;
          }
        } 
        return nums[low];
    }
}