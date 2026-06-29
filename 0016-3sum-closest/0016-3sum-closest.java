import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int first=0;
    int second=nums.length-1;
    int min = Integer.MAX_VALUE;
    int ans=min;
    for(int i=0;i<nums.length;i++){
     if(i>0  && nums[i-1]==nums[i]){
                continue;
     }
      first=i+1;
      second=nums.length-1;
      while(first<second){
       
       int total=nums[i]+nums[first]+nums[second];

       if(total==target){
        return total;
       }
       if (Math.abs(total-target)<min){
        min=Math.abs(total-target);
        ans=total;
       }
       else if(total<target){
        first+=1;
       }
       else{
        second-=1;
        }
    //    while(first>0 &&first<second && nums[first-1]==nums[first]){
    //      first+=1;
    //    }
    //    while( second < nums.length-1 && second>first && nums[second]==nums[second+1]){
    //     second-=1;
    }
      
    }
    return ans;
    }
}