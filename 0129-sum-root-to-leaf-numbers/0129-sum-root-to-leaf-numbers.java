
class Solution {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        count(root,root.val);
        return total;
    }
    void count(TreeNode node ,int curr){
        if(node.left==null && node.right == null){
            total += curr;
            return ;            
        }
        if(node.left!=null){
        count(node.left,(curr*10)+node.left.val);
        }
        if(node.right!=null){
        count(node.right,(curr*10)+node.right.val);
        }
        return;
    }

}