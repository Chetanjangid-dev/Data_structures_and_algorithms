class Solution {
    public int[] searchRange(int[] nums, int target) {
     int firstoccurence=-1;
     int secondoccurence=-1;
     int low=0;
     int high=nums.length-1;
     int mid;
     int[] arr = new int[2];
     arr[0]=firstoccurence;
     arr[1]=secondoccurence;
     while(low<=high){
        mid=(low+high)/2;
        if(nums[mid]==target){
            firstoccurence=mid;
            high=mid-1;
        }
        else if(nums[mid]>target){
            high=mid-1;
        }
        else{
            low=mid+1;             
      }
     }
       if(firstoccurence == -1){
         return arr;
       }     

       low=0;
       high=nums.length-1;

       while(low<=high){
        mid=(low+high)/2;
        if(nums[mid]==target){
            secondoccurence=mid;
            low=mid+1;
        }
        else if(nums[mid]>target){
            high=mid-1;
        }
        else{
            low=mid+1;             
      }
     } 
     arr[0]=firstoccurence;
     arr[1]=secondoccurence;
     return arr;    
    }
}