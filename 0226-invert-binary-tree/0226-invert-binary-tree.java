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
    public TreeNode invertTree(TreeNode root) {
        //if(node==null ||(node.left == null && nod.right == null)) return root;
        return invert(root);
    }
    TreeNode invert(TreeNode node){
     if(node == null  || (node.left==null && node.right==null)) return node;
     TreeNode left =  invert(node.left);
     TreeNode right = invert(node.right);
     TreeNode temp = right;
     node.right = left;
     node.left= temp;
     return node;//return inverted node 
    }
}