class Solution {
    int[] nums;
    boolean checksorted(int i,int j){
     if(i>=j) return true;
     for(int k =i ;k<j;k++){
        if(nums[k]>nums[k+1]) return false;
     }
     return true;
    }
    public boolean check(int[] nums) {
      this.nums=nums;
      int max_val_index = 0;
      int max_val = nums[max_val_index];
      for(int i  = 0 ;i<nums.length;i++){
        if(nums[i]>max_val){
            max_val_index=i;
            max_val = nums[max_val_index];
        }
      } 
      while(max_val_index+1 <nums.length && nums[max_val_index]== nums[max_val_index+1]){
        max_val_index++;
      }
      return checksorted(0,max_val_index-1) && checksorted(max_val_index+1,nums.length-1) &&  (nums[nums.length-1]<=nums[0]|| max_val_index ==nums.length-1);
    }
}