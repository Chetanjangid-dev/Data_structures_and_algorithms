
class Solution {
    int targetSum;
    List<List<Integer>> ans;
    List<Integer> temp;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      this.ans=new ArrayList<>();
      this.temp=new ArrayList<>();
      if(root==null) return ans;
      this.targetSum=targetSum;
      temp.add(root.val);
       pathsum(root,root.val);
       return ans;
    }
    void pathsum(TreeNode node,int path){
        if(node.left==null  && node.right==null){
            if(path==targetSum){
                ans.add(new ArrayList<>(temp));
                return ;
            }
            return ;
        }
     
        if(node.left!=null){
          temp.add(node.left.val);
           pathsum(node.left,path+node.left.val);
          temp.remove(temp.size()-1);
        }
        if(node.right!=null){
             temp.add(node.right.val);
             pathsum(node.right,path+node.right.val);
             temp.remove(temp.size()-1);
        }    
        return ;
    }
}