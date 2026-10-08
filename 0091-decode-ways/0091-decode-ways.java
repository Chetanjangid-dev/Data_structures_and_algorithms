class Solution {
    String s ;
    int[] dp;
    public int numDecodings(String s) {
         if(s.length()==0) return 0;
         this.s=s;
         int prev_one=1;
         int prev_two=0;
         for(int i = s.length()-1;i>=0;i--){
            int one=0;
            int two=0;
            if(Integer.parseInt(s.charAt(i)+"")>0){
              one =prev_one;
            }
           if(i+1<s.length() && s.charAt(i)!='0' && Integer.parseInt(s.charAt(i) +""+s.charAt(i+1)) <27 &&  Integer.parseInt(s.  charAt  (i) +""+s.charAt(i+1)) >0 ){
            two=prev_two;     
           }
           prev_two=prev_one;
           prev_one=one+two;
         }
         return prev_one;
    }
}