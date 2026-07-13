class Solution {
    public int findMin(int[] nums) {
     int low,high,mid;
     low=0;
     high=nums.length-1;
     while(low<high){
        mid=(low+high)/2;
        while(nums[mid]==nums[high] && (mid!=high)==true){
            high--;
        }
        //check sortd and unsoeryd 
        if(nums[mid]<nums[high] || mid==high){
            high=mid;
        }
        else{
             low=mid+1;
        }
        
     }   
     return nums[low];
    }
}