class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       if(s.length()<p.length()){
        return new ArrayList<>();
       }
        int[] freq=new int[26];
        int[] wind=new int[26];
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            freq[ch-'a']+=1;
        }
        // p size wind
        for(int i=0;i<p.length();i++){
            char ch=s.charAt(i);
            wind[ch-'a']+=1;
        }
         if(Arrays.equals(wind, freq)){
            ans.add(0);
            }
        // wind slide
        for(int i=p.length();i<s.length();i++){
            char add=s.charAt(i);
            char to_remove=s.charAt(i-p.length());
            wind[add-'a']+=1;
            wind[to_remove-'a']-=1;
            if(Arrays.equals(wind,freq)){
              ans.add(i-p.length()+1);
            } 
        }
        return ans;
    }
}