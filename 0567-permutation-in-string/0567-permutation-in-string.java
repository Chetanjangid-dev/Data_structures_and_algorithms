class Solution {
    HashMap<Character,Integer> s2_map ;
    boolean check( HashMap<Character,Integer>  s1_map ){
      for (Character key : s2_map.keySet()) {
           if(!s1_map.containsKey(key) || (int)s1_map.get(key)!= (int)s2_map.get(key)){
            return false;
           }
      }
     return true;
     }
    public boolean checkInclusion(String s2, String s1) {
        //always assume s1 shorter
        if(s2.length() > s1.length()) return false;
        //if(s2.length()>s1.length()) return false;
        this.s2_map =  new HashMap<>();
        HashMap<Character,Integer> s1_map =  new HashMap<>();
        for(int  i = 0 ;i<s2.length() ;i++){
            char ch =  s2.charAt(i);
           s2_map.put(ch, s2_map.getOrDefault(ch, 0) + 1);
        }
        // s2 size windw
        for(int i  = 0 ;i<s2.length() ;i++){
            char ch =  s1.charAt(i);
            s1_map.put(ch, s1_map.getOrDefault(ch, 0) + 1);
        }
        if(check(s1_map)) return true;
        for(int  i  = s2.length();i<s1.length() ;i++){
           char add =  s1.charAt(i);
           s1_map.put(add, s1_map.getOrDefault(add, 0) + 1);
           char rem = s1.charAt(i-s2.length());
           s1_map.put(rem,s1_map.get(rem)-1);
           if(s1_map.get(rem) == 0)  s1_map.remove(rem);
           if(check(s1_map)) return true;
        }
        return false;
    }
}