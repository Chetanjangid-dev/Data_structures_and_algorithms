
class Solution {
    TreeNode ans=null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
             
      findlca(root,p,q);
      return ans;
    }
    public int findlca(TreeNode root,TreeNode p,TreeNode q){
     // base case
     if (root==null){
        return 0;
     }
     int left=findlca(root.left,p,q);
     int right=findlca(root.right,p,q);
     int current=0;
     if(root.val==p.val || root.val==q.val){
        current=1;
     }
     //ya to answer mil gya 
     if(current+left+right==2 && ans==null){
        ans=root;
     }
     // ya asnwer nhi mila
     //total kite bosses mile -0/1/2
     return current+left+right;
    }
   
}