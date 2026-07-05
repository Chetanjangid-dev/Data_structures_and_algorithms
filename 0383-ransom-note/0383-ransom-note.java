class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
     HashMap<Character,Integer > map = new HashMap<>();
    
      for(int i=0;i<ransomNote.length();i++){
        char  currentchar=ransomNote.charAt(i);
        if(map.containsKey(currentchar)){
            map.put(currentchar,map.get(currentchar) +1);
        }
        else{
             map.put(currentchar,1);
        }
      }
       for(int j=0;j<magazine.length();j++){
        if(map.size()==0){return true;}
        char  currentchar=magazine.charAt(j);
        if(map.containsKey(currentchar)){
         map.put(currentchar,map.get(currentchar)-1);
         if(map.get(currentchar)==0){
            map.remove(currentchar);
         }
        }
      }
       return map.size()==0;
    }
}