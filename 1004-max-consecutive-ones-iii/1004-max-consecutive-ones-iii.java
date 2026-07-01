class Solution {
    public int longestOnes(int[] nums, int k) {
        int ones=0;
        int zeroes=0;
        int  first=0;
        int second=first;
        int max=0;
        while(second<nums.length){
            if(nums[second]==0){
                zeroes+=1;
            }
            else{
                ones+=1;
            }
              while(first<=second && k < zeroes){
                   if(nums[first]==0){
                    zeroes-=1;
                   }
                   else{
                    ones-=1;
                   }
                   first+=1;
              }
            
            max=Math.max(max,second-first+1);
            second+=1;
        }
        return max;
    }
}