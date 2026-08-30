
class Solution {
    List<Integer>  traversal ;
    public List<Integer> inorderTraversal(TreeNode root) {
        traversal =  new ArrayList<>();
        inorder(root);
        return traversal;
    }
    void inorder(TreeNode node){
        //base contions
        //if node is emopt
        if(node == null ) return ;
        // if the node is leaf
        if(node.left == null && node.right == null){
             traversal.add(node.val);
             return;
        }
        inorder(node.left);
        traversal.add(node.val);
        inorder(node.right);
        return ;
    }
}