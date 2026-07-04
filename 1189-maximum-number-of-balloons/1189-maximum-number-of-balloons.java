class Solution {
    public int maxNumberOfBalloons(String text) {
     HashMap<Character,Integer > map = new HashMap<>();
      for(int i=0;i<text.length();i++){
       char currentchar=text.charAt(i);
       if(currentchar=='b' || currentchar=='a' || currentchar=='l' || currentchar=='o' || currentchar=='n'  ){ 
        if(map.containsKey(currentchar)){
            map.put(currentchar,map.get(currentchar) +1);
        }
        else{
             map.put(currentchar,1);
        }
       }
      }
     
      if (map.size()<5){
        return 0;
      }
       map.put('o',map.get('o')/2);
       map.put('l',map.get('l')/2);
      int min = Integer.MAX_VALUE;
      char k = '\0';

       for (char key : map.keySet()) {
        if (map.get(key) < min) {
         min = map.get(key);
         k = key;
           }
      }
      return map.get(k);
    }
}