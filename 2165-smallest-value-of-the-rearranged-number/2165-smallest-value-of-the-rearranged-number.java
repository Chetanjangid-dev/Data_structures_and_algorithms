class Solution {
    public long smallestNumber(long num) {
        if(num>=-9 && num<=9) return num;
        boolean isneg = num<0;
        num = Math.abs(num);
        long div = 1;
        int size=1;
        while(num/div>=10){
            div*=10;
            size++;
        }
        int[] nums=  new int[size];

        int prev = 0;
        while (div > 0) {
           int digit = (int)(num / div);
           nums[prev] = digit;
           prev++;
           num %= div;
           div /= 10;
        }
        long ans = 0;
        Arrays.sort(nums);
        if(!isneg){
        int i = 0;
        while(nums[i] == 0){ i++;}
        ans = nums[i];
        int skip = i;
        i=0;
        while(i<nums.length){
            if(i==skip){ 
                i++;
                continue;
            }
            ans=ans*10+nums[i];
            i++;
        }
        }
        else{
          int i  = nums.length-1;
          while(i>=0){
            ans=ans*10+nums[i];
            i--;
          }   
        }
        if(isneg) return -ans;
        return ans;
    }
}