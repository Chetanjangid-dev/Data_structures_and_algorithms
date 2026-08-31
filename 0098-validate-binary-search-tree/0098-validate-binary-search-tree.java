class Solution {
    int prev ;
    boolean notsetted=true;
    boolean isvalid=true;
    public boolean isValidBST(TreeNode root) {
        search(root);
        return isvalid;
    }
    void search(TreeNode node){
         if(node==null || isvalid==false){return ;}
         search(node.left);
         if(notsetted){
              notsetted=false;
         }
         else if(node.val<=prev){
            isvalid=false;
            return ;
         }
         prev = node.val;  
         search(node.right);
    }
}