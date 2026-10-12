class Solution {
    public int romanToInt(String s) {
HashMap<Character, Integer> map = new HashMap<>();

map.put('I', 1);
map.put('V', 5);
map.put('X', 10);
map.put('L', 50);
map.put('C', 100);
map.put('D', 500);
map.put('M', 1000);
map.put('A',0);
      char prev = 'A';
      int ans = 0;
      for(int i = s.length()-1;i>=0;i--){
         char curr = s.charAt(i); 
         if(map.get(prev) >map.get(curr) ){
           ans -= map.get(curr);
         }
         else{
            ans+=map.get(curr);
         }
         prev=curr;
      }
       return ans;
    }
}