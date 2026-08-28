class Solution {
    int[]  candidates;
    int target;
    List<Integer> curr;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       this.candidates = candidates;
       this.target = target;
       this.curr = new ArrayList<>();  
       this.res = new ArrayList<>();  
       combo_sum(0,0);
       return res;     
    }
    public void combo_sum(int p , int total){
     if(total==target) {
        res.add(new ArrayList<>(curr));
        return ;
     }
     if(total>target) return ;
     for(int i = p ; i < candidates.length;i++ ){
        curr.add(candidates[i]);
        combo_sum(i,total+candidates[i]);
        curr.remove(curr.size()-1);
     }
     return;
    }
}