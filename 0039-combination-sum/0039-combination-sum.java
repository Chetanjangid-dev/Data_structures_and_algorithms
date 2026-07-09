class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> temp=new ArrayList<>();
    public void conbo(int start,int total, int target,int[] candidates){
        if(total==target){
            res.add(new ArrayList<>(temp));
            return ;
        }
        if(total>target){
          return ;
        }
        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            total+=candidates[i];
            conbo(i,total,target,candidates);
            total-=temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int total=0;
        conbo(0,total,target,candidates);
        return res;
    }
}