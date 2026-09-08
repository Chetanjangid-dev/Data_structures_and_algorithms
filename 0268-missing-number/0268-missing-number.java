class Solution {
    public int missingNumber(int[] nums) {
      int n= nums.length;
      int  i = 0;
      while(i<nums.length){
         while(nums[i]!=i && nums[i]!=n){
             int temp =nums[nums[i]];
             nums[nums[i]] = nums[i];
             nums[i] = temp;            
         }
         i++;
      }  
      for(i = 0 ;i <nums.length ;i ++){
        if(nums[i]!=i){
            return i;
        }
      }
      return n;
    }
}