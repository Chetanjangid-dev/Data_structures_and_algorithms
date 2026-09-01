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
    int p;
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.p = postorder.length;
        this.inorder=inorder;
        this.postorder=postorder;
        return construct(0,inorder.length-1);
    }
    TreeNode construct(int p1 ,int p2){
       if(p1>p2){
        return null;
       }
       p--;
       if(p1 == p2 ){
        return new TreeNode(inorder[p1]);
       }
       int center = p1;
       for(int i = p1;  i<= p2;i++  ){
            if(inorder[i]==postorder[p]){
                center = i;
                break;
            }
       }
       TreeNode root =  new TreeNode(inorder[center]);
       //right part ko phle dhnalde krha hova bcz rott ka bad yhi aata h phle hmare traversla me abckward me 
       root.right  = construct(center+1,p2);
       root.left  = construct(p1,center-1);
      
       return root;
    }
}