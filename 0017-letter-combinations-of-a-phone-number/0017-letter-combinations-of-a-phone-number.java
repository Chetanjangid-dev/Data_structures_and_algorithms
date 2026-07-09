class Solution {
    Map<Character, String>map = new HashMap<>() {{
    put('2', "abc");
    put('3', "def");
    put('4', "ghi");
    put('5', "jkl");
    put('6', "mno");
    put('7', "pqrs");
    put('8', "tuv");
    put('9', "wxyz");}};
    List<String> ans= new ArrayList<>();
    public void build(String s,String digits,int p){
       if(p==digits.length()){
        ans.add(s);
        return;
       }
       String curr=map.get(digits.charAt(p));
       for(int i=0;i<curr.length();i++){
         build(s+curr.charAt(i),digits,p+1);
       }
    }
    public List<String> letterCombinations(String digits) {
       build("",digits,0);
       return ans;
    }
}