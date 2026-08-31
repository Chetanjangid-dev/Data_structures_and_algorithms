
class Solution {
    boolean is=true;
    public boolean isBalanced(TreeNode root) {
     isbalanced(root);
     return is;
    }
    int isbalanced(TreeNode root){
      if(root==null) return 0;
        int left = isbalanced(root.left);
        int right = isbalanced(root.right);
        //invarinat check
        if(Math.abs(left-right)>1) {
            is=false;
        }
        return 1+Math.max(left,right);
    }
    
}