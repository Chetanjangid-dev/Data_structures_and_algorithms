
class Solution {
    int p = -1 ;
    int[] preorder;
    int[] inorder;
    //i j for partioning 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder=inorder;
        this.preorder=preorder;
        return construct(0,inorder.length-1);
    }
    TreeNode construct(int p1 ,int p2){
       if(p1>p2){
        return null;
       }
       p++;
       if(p1 == p2 ){
        return new TreeNode(inorder[p1]);
       }
       int center = p1;
       for(int i = p1;  i<= p2;i++  ){
            if(inorder[i]==preorder[p]){
                center = i;
                break;
            }
       }
       TreeNode root =  new TreeNode(inorder[center]);
       root.left  = construct(p1,center-1);
       root.right  = construct(center+1,p2);
       return root;
    }
}