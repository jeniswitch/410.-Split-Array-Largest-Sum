/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode next;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        next = null;
        helper(root, p);
        return next;
    }
    private void helper(TreeNode node, TreeNode p) {
        if(node == null){
            return;
        }
        if(node.val <= p.val) {
            helper(node.right, p);
        }
        else {
            next = node;
            helper(node.left, p);
        }
    }
}