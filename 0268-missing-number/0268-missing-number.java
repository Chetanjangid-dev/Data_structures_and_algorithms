class Solution {
    public int missingNumber(int[] nums) {
      //maping arr[i]=i;
      int i=0;
      while(i<nums.length){
        
        int correctindex=nums[i];
        if(nums[i]<nums.length && nums[i]!=nums[correctindex]){
           int temp=nums[i];
           nums[i]=nums[correctindex];
           nums[correctindex]=temp;   
        }
        else{
            i++;
        }
      } 
      for(int j=0;j<nums.length;j++){
        if(nums[j]!=j){
            return j;
        }
      }
      return nums.length;
    }
}