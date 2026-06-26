class Solution {
    int rootindicator;
     public TreeNode buildTree(int[] inorder, int[] postorder) {
         rootindicator=postorder.length-1;
         return   traverse(0,inorder.length-1,postorder,inorder);
    }
    
    public TreeNode traverse(int low ,int high,int[] postorder, int[] inorder ){
    if (high<low){return null;}
    // searching for root
    TreeNode root=new TreeNode (postorder[rootindicator]);
    int i=low;
    while(inorder[i]!=root.val && i<=high){
        i++;
    }
    rootindicator--; 
    root.right=traverse(i+1,high,postorder,inorder);
    root.left=traverse(low,i-1,postorder,inorder);
   
    return root;    
    }
 
}