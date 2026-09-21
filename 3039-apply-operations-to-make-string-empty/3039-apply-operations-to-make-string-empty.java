class Solution {
    public String lastNonEmptyString(String s) {
     int[] freq =  new int[26];
     String ans= "";
     int maxfreq= 0;
     for(int i = 0;i <s.length() ;i++){
        char ch =  s.charAt(i);
        freq[ch-'a']+=1;
        maxfreq = Math.max(maxfreq,freq[ch-'a']);
     }   
     HashMap<Character,Integer> map = new HashMap<>();
     for(int i =0;i<s.length() ; i++){
        if(maxfreq!=0 && freq[s.charAt(i) - 'a']==maxfreq){
          map.put(s.charAt(i),i);  
        }
     }
     List<Map.Entry<Character, Integer>> list =
        new ArrayList<>(map.entrySet());
     Collections.sort(list, Map.Entry.comparingByValue());
     StringBuilder sb =  new StringBuilder();   
for (Map.Entry<Character, Integer> entry : list) {
      char ch = entry.getKey();
       sb.append(ch);  
 }
    return sb.toString();
    }
}