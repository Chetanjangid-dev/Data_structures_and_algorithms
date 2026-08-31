class Solution {
    public TreeNode searchBST(TreeNode node, int val) {
       if(node == null ) return node;
       if(node.val == val ) return node;
       else if(node.val < val ){
          return searchBST(node.right,val);
       }   
       return searchBST(node.left,val);
    }
}