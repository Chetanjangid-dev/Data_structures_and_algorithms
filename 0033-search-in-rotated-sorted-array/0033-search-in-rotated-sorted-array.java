class Solution {
    public int search(int[] nums, int target) {
      int low,high,mid;
      low=0;
      high=nums.length-1;
     //we domt knnpw ans exots or not so using low<=high 
      while(low<=high){
       mid=(low+high)/2;
       if(nums[mid]==target){
        return mid;
       }
       //mid to high sorted
       if(nums[mid]<nums[high]){
           if(nums[mid]<target && nums[high]>=target){
             low=mid+1;
           }
           else{
             high =mid-1;
           }
       }
       //low to high sorted
       else{
         if(nums[low]<=target && nums[mid]>target){
            high=mid-1;
         }
         else{
           low=mid+1;
        }
       }
      } 
      return -1;
    } 
}