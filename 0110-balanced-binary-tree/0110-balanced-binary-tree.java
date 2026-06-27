class Solution {
    boolean ans=true;
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=depth(root.left);
        int right=depth(root.right);
        if(Math.abs(left-right)>1){
            ans=false;
        }
        return 1+Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
       depth(root);
       return ans;       
    }
}