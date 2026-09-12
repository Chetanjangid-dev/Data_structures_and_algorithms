class Solution {
    String prev = "0";
    public int[] countBits(int n) {
     int[] ans =  new int[n+1];
     ans[0] = 0;
      for(int  i = 1 ; i <=  n;i++){
        ans[i] = countbits();
      }
      return ans;   
    }
    int countbits(){
        boolean seted = false;
        int count = 0;
        StringBuilder sb =  new StringBuilder(prev);
        for(int i = prev.length()-1 ; i>= 0 ; i--){
            if(prev.charAt(i) == '1'){
                 sb.setCharAt(i, '0');
            }
            if(prev.charAt(i) == '0'){
                sb.setCharAt(i,'1');
                seted = true;
                break;
            }
        }
        if(!seted){
           prev = 1 + sb.toString();
        }
        else{
        prev = sb.toString(); 
        }
        for(int   i = 0; i < prev.length() ;i++ ){
           if( prev.charAt(i)=='1') count ++;
        }
        return count;
    }
}