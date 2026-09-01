
class Solution {
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums=nums;
        return construct(0,nums.length-1);
    }
    TreeNode construct(int p1 ,int p2){
     if(p1>p2){
        return null;
     }
     int center =( p1 + p2 )/ 2;
     TreeNode root =  new TreeNode(nums[center]);
     root.left = construct(p1,center-1);
     root.right = construct(center+1,p2);
     return root;  
    }
}