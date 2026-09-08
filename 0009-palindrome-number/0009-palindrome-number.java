class Solution {
    public boolean isPalindrome(int x) {
      if(x<0) return false;
      //right to left digit extraction
      int n =x;
      x=n;
      if(x>=0 && x<=9) return true;
      int div  = 1;
      while(n/div >= 10){
         div*=10;
      }        
      while(div!=0 && x!=0){
          int left = n/div;
          int right = (x%10);
          if(left !=right)  return false;
          x= x/10;
          n = n % div;
          div/=10;
      }
      return true;
    }
}