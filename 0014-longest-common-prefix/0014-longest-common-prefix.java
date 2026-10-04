class Solution {
    public String longestCommonPrefix(String[] strs) {
       int smallestStringindex = -1 ;
       int smallestsize  = Integer.MAX_VALUE;
       for(int  i  = 0 ; i< strs.length ;i++){
          smallestsize  = Math.min( strs[i].length() , smallestsize);
          smallestStringindex  =i;
       }
       int lcpindex =0;
       String smalleststring = strs[smallestStringindex];
       for(int  i  =  0  ; i  < smallestsize;i++){
        char comp  = smalleststring.charAt(i);
        for(int   j = 0 ;j < strs.length ; j++){
             if(strs[j].charAt(i) != comp){
                return smalleststring.substring(0,lcpindex);
             }
        }
        lcpindex++;
       }
       return smalleststring.substring(0,lcpindex);
    }
}
//tc  o(w*n*w) w2n 