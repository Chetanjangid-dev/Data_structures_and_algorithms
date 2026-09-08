class Solution {
    public int reverse(int x) {
     if((x<0 && x==Integer.MIN_VALUE )|| ((x>0) && x==Integer.MAX_VALUE )) return 0;
     int rev=0;
     while(x!=0){
       int digit = x%10;
       x=x/10;
       if(rev>(Integer.MAX_VALUE/10) || rev < (Integer.MIN_VALUE/10) ) return 0;
       rev=(rev*10)+ digit; 
     }  
     return rev; 
    }
}