
class Solution {
    TreeNode ans=null;
    public int maxdepth(TreeNode root){
         if(root==null){
            return 0;
         }
         return 1+Math.max(maxdepth(root.left),maxdepth(root.right));
    }
    public void traverse(TreeNode root){
    if (root==null){
        return ;
    }
    //max depth of left and right
    int left=maxdepth(root.left);
    int right=maxdepth(root.right);
    if(left==right && ans==null){
        ans=root;
        return;
    }
    if(left>right){
        traverse(root.left);
    }
    if(right>left){
       traverse(root.right);
    }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
     traverse(root);
     return ans;  
    }
}