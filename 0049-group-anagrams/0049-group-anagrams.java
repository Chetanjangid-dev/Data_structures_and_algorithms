class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            // string are imuutable thats why we cant directly sort it

            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
           String key = new String(ch);
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