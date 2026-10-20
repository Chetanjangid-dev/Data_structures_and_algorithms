class Solution {
    public long smallestNumber(long num) {
        if(num>=-9 && num<=9) return num;
        if(num ==  Long.MIN_VALUE ) return num;
        boolean isneg = num<0;
        num = Math.abs(num);
        long div = 1;
        int size=1;
        while(num/div>=10){
            div*=10;
            size++;
        }
        int[] nums=  new int[10];
        while (div > 0) {
           int digit = (int)(num / div);
           nums[digit]++;
           
           num %= div;
           div /= 10;
        }
        long ans = 0;
        if(isneg){
          int  i = 9;
          while(i>=0){
            while(nums[i]>0){
              ans = ans*10+i;
              nums[i]--;  
            }
            i--;
          }
        }
        else{
            int i  = 1;
            while(nums[i]==0) i++;
            ans = ans*10+i;
            nums[i]--;
            while(nums[0]>0){
                ans=ans*10+0;
                nums[0]--;
            }
            i = 1;
            while(i<nums.length){
                while(nums[i]>0){
                ans=ans*10+i;
                nums[i]--;
                }
                i++;
            }           
        }
        if(isneg) return -ans;
        return ans;
    }
}