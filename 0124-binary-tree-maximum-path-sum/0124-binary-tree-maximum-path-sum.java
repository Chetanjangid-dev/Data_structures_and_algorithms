class Solution {
    //timme =o(n)
    //space=o(d); d=diameter of tree
    Integer globalmax=null;
    public int maxsum(TreeNode root){
      if(root==null){return 0;}
       int leftsidesum=maxsum(root.left);
       int  rightsidesum=maxsum(root.right);
      if(globalmax==null){globalmax=root.val;}//sirf ek abr chelga
        int res= Math.max(root.val+leftsidesum,Math.max(root.val+rightsidesum,root.val));
        globalmax=Math.max(globalmax,Math.max(res,leftsidesum+rightsidesum+root.val));
        return res;
    }
    public int maxPathSum(TreeNode root) {
      maxsum(root);
      if(root==null){return 0;}
      return globalmax;
    }
}