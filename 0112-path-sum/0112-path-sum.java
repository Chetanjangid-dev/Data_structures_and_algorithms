/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int targetSum;
    TreeNode root;
    public boolean hasPathSum(TreeNode root, int targetSum) {
      if(root==null) return false;
      this.targetSum=targetSum;
      this.root=root;
      return pathsum(root,root.val);
    }
    boolean pathsum(TreeNode node,int path){
        if(node.left==null  && node.right==null){
            if(path==targetSum  ){
                return true;
            }
            return false;
        }
        boolean left=false;
        boolean right=false;
        if(node.left!=null){
          left= pathsum(node.left,path+node.left.val);
        }
        if(node.right!=null){
           right= pathsum(node.right,path+node.right.val);
        }    
        return left||right;
    }
}