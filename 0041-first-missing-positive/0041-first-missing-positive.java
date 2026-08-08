class Solution {
    public int firstMissingPositive(int[] nums) {
     //int min=posinf
     HashSet<Integer> set= new HashSet<>();
     int max=nums[0];
     for(int i=0;i<nums.length;i++){
        if(nums[i]<=0){
            continue;
        }
        if(nums[i]>0){
         set.add(nums[i]);
        }
        if(nums[i]>max){
            max=nums[i];
        }
        
     }
     int min_int=1;    
     for(int i=1;i<=nums.length+1;i++){
        if(set.contains(min_int)){
            min_int++;
        }
     }  
     return min_int;  
    }
}