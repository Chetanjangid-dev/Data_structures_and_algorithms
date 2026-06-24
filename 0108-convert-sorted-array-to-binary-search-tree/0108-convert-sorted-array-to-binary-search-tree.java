/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

}
class Solution { 
  TreeNode head = null; 
   public TreeNode made(int low,int high,int[] nums){
     if(high<low){return null; }
     int mid=(low+high)/2;
     TreeNode root =  new TreeNode(nums[mid]);
     if(head==null){head=root;}
     root.left = made(low,mid-1,nums);
     root.right = made(mid+1,high,nums);
     return root;
   }
    public TreeNode sortedArrayToBST(int[] nums) {
    int low=0;
    int high=nums.length-1;
    made(low,high,nums);
    return head; 
   }

} 