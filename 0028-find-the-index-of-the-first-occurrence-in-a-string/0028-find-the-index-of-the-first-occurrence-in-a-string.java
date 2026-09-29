class Solution {
    String needle;
    String haystack;
    boolean isequal(int i,int j){
       int p1=0;
       int p2 =i;
       while(p1<needle.length() && p2<=j){
         if(needle.charAt(p1) != haystack.charAt(p2)){
            return false;
         }
         p1++;
         p2++;
       }
       return true;
    }
    public int strStr(String haystack, String needle) {
        this.needle  = needle;
        this.haystack = haystack;
        for(int  i  = 0 ;i<= haystack.length()-needle.length();i++){
            if(haystack.charAt(i) == needle.charAt(0) && isequal(i,i+needle.length()-1)){
                return i;
            }
        }
        return -1;
    }
}