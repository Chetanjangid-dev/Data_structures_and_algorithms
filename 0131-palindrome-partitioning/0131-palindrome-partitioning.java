class Solution {
    List<List<String>> ans=new ArrayList<>();
    List<String> temp=new ArrayList<>();
    public boolean ispalindrome(String s){
        int p1=0;
        int p2=s.length()-1;
        while(p1<p2){
            if(s.charAt(p1)!=s.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
    public void partitioning(String s,List<String> temp,int pointer){
        if(pointer==s.length()){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        String ch="";
        for(int p=pointer ; p<s.length();p++){
             ch+=String.valueOf(s.charAt(p));
            if(ispalindrome(ch)){
                temp.add(ch);
                partitioning(s,temp,p+1);
                temp.remove(temp.size()-1);
            }
        }
        return ;
    }   
    public List<List<String>> partition(String s) {
         partitioning(s,temp,0); 
         return ans;   
    }
}