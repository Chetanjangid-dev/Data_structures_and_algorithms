class Solution {
    TreeNode prev,curr;
    TreeNode runningprev=null;
    int errorfound=0;
    public void recoverTree(TreeNode root) {
           traverse(root);
          if(prev!=null && curr!=null){
             int temp = prev.val;
             prev.val = curr.val;
             curr.val =temp;
          }
          return ;
    }
    void traverse(TreeNode node){
        if(node==null){
            return;
        }
        traverse(node.left);
        if(runningprev!=null &&runningprev.val>node.val&& errorfound<2){
            errorfound++;
            if(errorfound==1){
                 prev=runningprev;
            }
            curr = node;  
        }
        runningprev =node;
        traverse(node.right);
    }
}