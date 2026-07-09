class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public void calc(List<Integer> temp,int[] nums){
     if(temp.size()==nums.length){
        ans.add(new ArrayList<>(temp));
                           
        return ;
      }
      for(int i=0;i<nums.length;i++){
       if(! set.contains(nums[i])){ 
        temp.add(nums[i]);
        set.add(nums[i]);
        calc(temp,nums);
        set.remove(temp.remove(temp.size()-1));
       }
      }
     }
    public List<List<Integer>> permute(int[] nums) {
        calc(temp,nums);
        return ans;       
    }
}