class Solution {
    public int square(int n ){
        if(n==1){return 1;}
        int digit;
        int digitsquare=0;
        while(n!=0){
            digit=n%10;
            digitsquare += (digit * digit);
            n=(n-digit)/10; 
        }
        return digitsquare;
    } 
    public boolean isHappy(int n) {
    int slow=n;
    int fast=n;
    while(slow !=1 && fast !=1 ){
      slow = square(slow);
      fast=square(square(fast));
      if(slow==fast && slow!=1){
        return false;
      }
    }
    return true;
    }
}