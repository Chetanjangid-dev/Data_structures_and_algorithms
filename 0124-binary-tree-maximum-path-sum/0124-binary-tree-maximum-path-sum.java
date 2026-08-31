class Solution {
    int global_max;
    public int maxPathSum(TreeNode root) {
        if(root==null) return -1;
        this.global_max=root.val;
        max(root);
        return global_max;
    }
    int max(TreeNode node){
      if(node==null){
        return 0;
      }
      //ye contion rkhni h to glbal max tutdnat update krna hoa ya ise remove krdo 
      if(node.left==null && node.right==null) {
         global_max=Math.max(global_max,node.val);       
         return node.val;}
      int curr = node.val; 
      int left = max(node.left);
      int  right = max(node.right);
      global_max = Math.max(curr,Math.max(curr+left,Math.max(curr+right,Math.max(left+curr+right,global_max))));
      return Math.max(curr + left, Math.max(curr+right,curr));
    }

}