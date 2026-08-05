class Solution {
    public int[] productExceptSelf(int[] nums) {
     if(nums.length==0){
        return new int[]{};
     }
     // prefix array and uffix array
     //prefix[i]=0 to i-1 indexed elements product not inlcuded i 
     //suffix[i] = i+1 to n-1 indexed elemmets totl product
     int[] prefix= new int[nums.length];
     prefix[0]=1;
     int[] ans= new int[nums.length];
     int[] suffix = new int[nums.length];
     suffix[nums.length-1]=1;
     for(int i=1;i<nums.length;i++){   
        prefix[i]=prefix[i-1]*nums[i-1];
     }   
     for(int i=nums.length-2;i>=0;i--){
        suffix[i]=suffix[i+1]*nums[i+1];
     }
     int product=suffix[0]*nums[0];
     for(int i=0;i<nums.length;i++){
        ans[i]=prefix[i]*suffix[i];
     }
     return ans;
    }
}