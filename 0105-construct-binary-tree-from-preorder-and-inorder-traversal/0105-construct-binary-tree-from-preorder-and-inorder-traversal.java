class Solution {
    int rootindicator=0;
    public TreeNode traverse(int low ,int high,int[] preorder, int[] inorder){
    if (high<low){return null;}
    // searching for root
    TreeNode root=new TreeNode (preorder[rootindicator]);
    int i=low;
    while(inorder[i]!=root.val && i<=high){
        i++;
    }
    rootindicator++;
    root.left=traverse(low,i-1,preorder,inorder);
    root.right=traverse(i+1,high,preorder,inorder);
    return root;    
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     return   traverse(0,inorder.length-1,preorder,inorder);
    }
}