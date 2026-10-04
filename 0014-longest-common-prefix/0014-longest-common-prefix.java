class Solution {
    public String longestCommonPrefix(String[] strs) {
       int smallestStringindex = -1 ;
       int smallestsize  = Integer.MAX_VALUE;
       for(int  i  = 0 ; i< strs.length ;i++){
          smallestsize  = Math.min( strs[i].length() , smallestsize);
          smallestStringindex  =i;
       }
       String lcp = "";
       String smalleststring = strs[smallestStringindex];
       for(int  i  =  1  ; i  <= smallestsize;i++){
        String compare  =  smalleststring.substring(0,i);
        for(int   j = 0 ;j < strs.length ; j++){
            if(!strs[j].substring(0,i).equals(compare)){
                return lcp;
            }
        }
        lcp = compare;
       }
       return lcp;
    }
}