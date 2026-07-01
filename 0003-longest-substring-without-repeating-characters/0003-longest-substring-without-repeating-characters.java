class Solution {
    public int lengthOfLongestSubstring(String s) {
        int first=0;
        int second=first;
        int max=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(second<s.length()){
            if(map.containsKey(s.charAt(second)) ){
             map.put(s.charAt(second),map.get(s.charAt(second))+1);
            }
            else{
                 map.put(s.charAt(second),1);
            }
            while(first<=second && map.size()<second-first+1){
                map.put(  s.charAt(first) ,map.get(s.charAt(first))-1  );
                if(map.get(s.charAt(first))==0 ){
                    map.remove(s.charAt(first));
                }
                first+=1;
            }
            if(map.size()==second-first+1){
                max=Math.max(max,second-first+1);
            }
            second+=1;
        }
        return max;

    }
}