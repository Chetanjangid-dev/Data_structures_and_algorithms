class pair{
    int depth;
    TreeNode lca;
    pair(TreeNode lca,int depth){
        this.depth=depth;
        this.lca=lca;

    }
}

class Solution {  
    public  pair  findlca(TreeNode  root ){
    if (root==null){
        return new pair(null,0);
    }
    pair left=findlca(root.left);
    pair right=findlca(root.right);;
    if (left.depth==right.depth){
         return new pair(root,left.depth+1);
    }
    if(left.depth>right.depth){
        return new pair(left.lca,left.depth+1);
    }
    else{
        return new pair(right.lca,right.depth+1);
    }
    }   
    public TreeNode lcaDeepestLeaves(TreeNode root) {
       if (root==null){return null;}
       return findlca(root).lca;
    }
}