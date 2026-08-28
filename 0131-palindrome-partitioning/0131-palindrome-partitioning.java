class Solution {
    String s;
    List<String> curr;
    List<List<String>> res;
    int n;
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>(); 
        this.curr  =  new ArrayList<>(); 
        this.s=s;
        this.n=s.length();
        rec(0,"");
        return res;
    }
    void rec(int p ,String currstr){
       if(p == n && currstr==""){
          res.add(new ArrayList<>(curr));
       }
       for(int  i = p ; i < n; i++ ){
         currstr += s.charAt(i); 
         if(ispalindrome(currstr)) {
            curr.add(currstr);
            rec(i+1,"");
            curr.remove(curr.size()-1);
         } 
       }
       return;
    }
    boolean ispalindrome(String currstr){
        int  i = 0;
        int j = currstr.length()-1;
        while(i<j){
            if(currstr.charAt(i)!=currstr.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}