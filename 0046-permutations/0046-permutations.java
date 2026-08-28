class Solution {
    int[] nums;
    int[] visited;
    List<Integer> currpath ;
    List<List<Integer>> result; 
    public List<List<Integer>> permute(int[] nums) {
        this.nums=nums;
        this.visited =  new int[nums.length];
        currpath = new ArrayList<>();
        result = new ArrayList<>();
        permutations();
        return result;
    }
    public void permutations(){
      if(currpath.size() == nums.length){
          result.add(new ArrayList<>(currpath));
          return ;
      }
      for(int i = 0 ; i<nums.length;i++  ){
        if(visited[i]==0){
           currpath.add(nums[i]);
           visited[i]=1;
           permutations();
           visited[i]=0;
           currpath.remove(currpath.size()-1);
        }
      }
    }
}