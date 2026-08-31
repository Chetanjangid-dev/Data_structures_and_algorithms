
class Solution {
    int global=0;
    public int diameterOfBinaryTree(TreeNode root) {
       max(root);
       return global;
    }
    int max(TreeNode root){
      if(root==null) return 0;
        int left = max(root.left);
        int right= max(root.right);
        global=Math.max(global,left+right);
        return 1+Math.max(left,right);
    }
}