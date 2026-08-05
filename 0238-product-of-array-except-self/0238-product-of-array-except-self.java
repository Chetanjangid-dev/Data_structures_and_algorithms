class Solution {
    public int[] productExceptSelf(int[] nums) {
     if(nums.length==0){
        return new int[]{};
     }
     int[] ans = new int[nums.length];
     ans[nums.length-1]=1;  
     for(int i=nums.length-2;i>=0;i--){
        ans[i]=ans[i+1]*nums[i+1];
     }
     int product=ans[0]*nums[0];
     int prev_product=1;
     for(int i=0;i<nums.length;i++){
        int temp=prev_product*nums[i];
        ans[i]=prev_product*ans[i];
        prev_product=temp;
        
     }
     return ans;
    }
}