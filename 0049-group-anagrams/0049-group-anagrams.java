class Solution {
    public boolean is_anagram(String s, String t) {
     if(s.length() != t.length()){
        return false;
     }
     HashMap<Character,Integer> map= new HashMap<>();
     for(int i=0;i<s.length();i++){
        char ch= s.charAt(i);
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }
        else{
            map.put(ch,1);
        }
     }
     for(int i=0;i<t.length();i++){
         char ch=t.charAt(i);
         if(!map.containsKey(ch)){
            return false;
         }
         map.put(ch,map.get(ch)-1);
         if(map.get(ch)==0){
            map.remove(ch);
         }
         }
       return map.size()==0;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans= new ArrayList<>();
        int[] visited= new int[strs.length];
        for(int i=0;i<strs.length;i++){
           if(visited[i]==0){
            String s1=strs[i];
            List<String> temp=new ArrayList<>();
            temp.add(s1);
            visited[i]=1;
            for(int j=i+1;j<strs.length;j++){
                String s2=strs[j];
                if(is_anagram(s1,s2)){
                  temp.add(s2);
                  visited[j]=1;;
                }
            }
            ans.add(temp);
           }
        }
        return ans;
    }
}