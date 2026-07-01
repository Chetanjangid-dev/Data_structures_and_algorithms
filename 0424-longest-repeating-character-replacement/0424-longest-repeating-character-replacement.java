class Solution {
    public int characterReplacement(String s, int k) {
       
        int first=0;
        int second=first;
        int max=0;
        int hash_max=0;
       
        HashMap<Character, Integer> map = new HashMap<>();
        while(second<s.length()){
            if(map.containsKey(s.charAt(second)) ){
             map.put(s.charAt(second),map.get(s.charAt(second))+1);
            }
            else{
                 map.put(s.charAt(second),1);
            }
            hash_max=Math.max(map.get(s.charAt(second)) , hash_max);
            while(first<=second && ( second-first+1 )- hash_max > k  ){
               
                map.put(  s.charAt(first) ,map.get(s.charAt(first))-1  );
                 //hash_max=Math.max(map.get(s.charAt(first)) , hash_max);              
                if(map.get(s.charAt(first))==0 ){
                    map.remove(s.charAt(first));
                 }
                        
                  first+=1;
            }    
            max=Math.max(max,second-first+1);
            second+=1;
        }
        return max;




    }
}