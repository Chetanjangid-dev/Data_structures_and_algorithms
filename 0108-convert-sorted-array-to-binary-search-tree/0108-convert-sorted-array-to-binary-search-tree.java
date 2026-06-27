
class Solution {
    public TreeNode build(int low,int high,int[] nums){
     if(high<low){
        return null;
     }
     int mid=(low+high)/2;
     TreeNode root=new TreeNode(nums[mid]);
     root.left=build(low,mid-1,nums);
     root.right=build(mid+1,high,nums);
     return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
       return  build(0,nums.length-1,nums);
    }
}