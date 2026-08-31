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
    int kthsmallest;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        search(root);
        return kthsmallest;
    }
    void search(TreeNode node){
        if(node==null || k==0) return ;
        search(node.left);
        k--;
        if(k==0){
             kthsmallest = node.val;
             return ;             
        }
        search(node.right);
    }
}