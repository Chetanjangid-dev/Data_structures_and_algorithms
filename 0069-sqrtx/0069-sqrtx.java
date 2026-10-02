class Solution {
    public int mySqrt(int x) {
       if(x==0) return 0;
       int low = 1;
       int high = x/2;
       while(low<high){
         int mid = (low+high+1)/2;
         if((long)mid*mid <= x){
            low=mid;
         }
         else{
            high =mid-1;
         }
       }       
        return  low;
    }
}