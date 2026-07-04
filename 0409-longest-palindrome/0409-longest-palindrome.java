class Solution {
    public int longestPalindrome(String s) {
     
       HashMap<Character,Integer > map = new HashMap<>();
      for(int i=0;i<s.length();i++){
       char  currentchar=s.charAt(i);
        if(map.containsKey(currentchar)){
            map.put(currentchar,map.get(currentchar) +1);
        }
        else{
             map.put(currentchar,1);
        }
      }
     int count=0;
     boolean isodd=false;
     for (char key : map.keySet()){
         if(map.get(key)%2==0) {
             count+=map.get(key);
         }
         else{
            isodd=true;
             count+=map.get(key)-1;
         }
       }
       if(isodd){
        return count+1;
       }
      return count;       
    }
}