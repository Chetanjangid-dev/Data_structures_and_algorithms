class Solution {
    public int search(int[] nums, int target) {
        //find sorted part
        //check if answer cn be exist in sorted part
        //if yes then search in it
        //if no the search in unsroted part
        //low<=higgh wehn we are not sure about answer existence
        //low<high-when we are 100% sure
        int low=0;
        int high=nums.length-1;
        int mid;
        while(low<=high){
           mid=(low+high)/2;
           if(nums[mid]==target){
            return mid;
           }
           else if(nums[mid]<=nums[high]){ 
                if(target>nums[mid] && nums[high]>=target){
                  low=mid+1;
                }
                else{
                    high=mid-1;
                }
           }
           else{
              if(target<nums[mid] && target>=nums[low]){
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