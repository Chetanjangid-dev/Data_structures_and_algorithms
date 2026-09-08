class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      int  i  = 0 ;
      int n =nums.length;
      while(i<nums.length){
        while(nums[i]!=i+1  && nums[nums[i]-1] != nums[i]){
            int temp  =  nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            nums[i] =temp;
        }
        i++;
      }     
      List<Integer> ans =  new ArrayList<>();
      for(i = 0 ;i<n;i++){
        if(nums[i]!=i+1){
          ans.add(i+1);
        }
      }  
      return ans;
    }
}