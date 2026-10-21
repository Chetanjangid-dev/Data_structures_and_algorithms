class Solution {
    List<List<Integer>> ans ;
    int n;
    int k;
    List<Integer> temp ;
    void combinations(int curr,int remaining){
     if(remaining == 0 ){
        ans.add(new ArrayList<>(temp));
        return ;
     }
     if(curr>n) return ;
     //choose curr
     temp.add(curr);
     combinations(curr+1,remaining-1);
     temp.remove(temp.size()-1);
     //skip current
     combinations(curr+1,remaining);
     return ;
    }
    public List<List<Integer>> combine(int n, int k) {
         this.ans =  new ArrayList<>();  
         this.n=n;
         this.k=k;
         this.temp=new ArrayList<>();
         if(n==k){
             for(int i =1;i<=n;i++){
                temp.add(i);
             }
             ans.add(temp);
             return ans;
         }
         combinations(1,k);
         return ans;
    }
}