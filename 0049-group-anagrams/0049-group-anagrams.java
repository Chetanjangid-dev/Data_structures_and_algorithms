class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        int[] count;
         for(int i=0;i<strs.length;i++){
            count= new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                char ch = strs[i].charAt(j);
                count[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int k = 0; k < 26; k++) {
                sb.append('#');
                sb.append(count[k]);
            }

            String key = sb.toString();
          
            if(map.containsKey(key)){
                List <String> temp= map.get(key);
                temp.add(strs[i]);
                map.put(key,temp);
            }
            else{
                List <String> temp= new ArrayList<>();
                temp.add(strs[i]);
                map.put(key,temp);
            }
        }
      List<List<String>> ans= new ArrayList<>();
       
       for (List<String> value : map.values()) {
          ans.add(new ArrayList<>(value));      
         }
       return ans;
      }
}
//tc-o(nklogk) and space-o(n+k)
// why do we need sorting = to amek a unique key teh undique jey shoding the grouo of nagrams is key ki values h nem sbme counnt of chars same h bus order diffen h chars ka 
///insted we ab use 26  lleeter feeq ary means mano agr ek string abcd and ek h bacd dono k liyerespectively count updtae kro you will  not thee arrya are same bcz order doesnt matter the value count incres as it so why we cang use it as identifier just say 10101000000000.. idefines the freq of str and str2 means they are anagrams so we will use it as key or as smilarity