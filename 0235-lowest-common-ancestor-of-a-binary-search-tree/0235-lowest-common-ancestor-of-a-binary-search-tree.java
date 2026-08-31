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
    TreeNode lca;
    TreeNode p;
     TreeNode q;
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        //i'll assume alsways p>q
        if(p.val>q.val){
        this.p=p;
        this.q=q;
        }
        else{
        this.q=p;
        this.p=q;
        }
        lca(node);
        return lca;
    }
    void lca(TreeNode node){
        if(node==null) return;
        if(node.val<=p.val && node.val >= q.val){
            lca = node;
            return ;
        } 
        else if(node.val > p.val){
            lca(node.left);
        }
        lca(node.right);
        return ;
    }
}