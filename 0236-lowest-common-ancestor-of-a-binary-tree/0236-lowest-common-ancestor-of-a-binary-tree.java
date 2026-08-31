/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca = null;
    TreeNode p;
    TreeNode  q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p=p;
        this.q=q;
        lca(root);
        return lca;
    }
    int lca(TreeNode node){
        if(node==null){
            return 0;
        }
        int curr,left,right,total;
        curr=0;
        left = 0;
        right=0;
        if(node.val == p.val || node.val == q.val) curr = 1;
        left = lca(node.left);
        right = lca(node.right);
        total = curr+left+right;
        if(total == 2 && lca==null){
            lca = node;
        } 
        return total;
    }
}