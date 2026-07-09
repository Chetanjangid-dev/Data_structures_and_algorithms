class Solution {
    List<String> ans=new ArrayList<>();
    public void generate(String s,int open ,int close,int n){
        // base case
       if(open==close && open==n){
        ans.add(s);
        return ;
       }
       if(close>open){return;}
       //take a choice and make it not choosen 
       if(open+1<=n){ 
       generate(s+"(",open+1,close,n);
       }
       if(close<open){
       generate(s+")",open,close+1,n);
       }
       return ;
    }
    public List<String> generateParenthesis(int n) {
        String s="";
        generate(s,0,0,n);
        return ans; 
    }
}