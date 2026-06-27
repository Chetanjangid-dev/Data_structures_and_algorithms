class Solution {
    int maxdepth=0;
    public int depth(TreeNode root){
        if(root==null){return 0;}
        int left=depth(root.left);
        int right=depth(root.right);
        maxdepth=Math.max(left+right,maxdepth);
        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxdepth;
    }
}