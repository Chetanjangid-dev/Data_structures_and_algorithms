class Solution {
    int[] nums;
    List<Integer> temp;
   List<List<Integer>> res;
    void subset(int i){
      if(i>=nums.length){
        res.add(new ArrayList<>(temp));
        return ;
      }
      //choose
      temp.add(nums[i]);
      subset(i+1);
      temp.remove(temp.size()-1);
      //skip
      subset(i+1);
      return ;
    }
    public List<List<Integer>> subsets(int[] nums) {
        this.temp =  new ArrayList<>();
        this.res =  new ArrayList<>();
        this.nums=nums;
        subset(0);
        return res;
    }
}