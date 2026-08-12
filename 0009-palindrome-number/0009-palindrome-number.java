class Solution {
    public boolean isPalindrome(int x) {
      if(x<0){
        return false;
      }
      if(x>=0 && x<10){
        return true;
      }
      int y=x;
      //left digit ==right digtit extraction
      int divisor = 1;
      while (y / divisor >= 10) {
       divisor *= 10;
      }
      while(x!=0 && divisor>0){
         int digit_from_right = (x%10);
         int digit_from_left = (y/divisor);
         y %= divisor;
         divisor /= 10;
         x=(x-digit_from_right)/10;
         if(digit_from_left !=  digit_from_right){
            return false;
         }
      }
      return true;
    }
}