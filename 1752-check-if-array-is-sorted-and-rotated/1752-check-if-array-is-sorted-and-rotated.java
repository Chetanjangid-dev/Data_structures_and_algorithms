class Solution {
    public boolean check(int[] nums) {
     int count = 0;
     int  n = nums.length;
     for(int i = 0 ;i<=(2*(n-1));i++)
     {
        if(nums[i%n]<=nums[(i+1)%n]) {
            count++;
            if(count==n-1) return true;
        }
        else{
            count=0;
        }
        
     }
     return count==n;   
    }
}