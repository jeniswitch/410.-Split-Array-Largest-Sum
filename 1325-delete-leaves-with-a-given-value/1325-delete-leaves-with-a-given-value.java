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
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) {
            return null;
        }
        helper(root, target);
        if(root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
    private TreeNode helper(TreeNode node, int target) {
        if(node == null) return null;
        if(node.left == null && node.right == null) {
            return node.val == target ? node : null;
        }
        TreeNode left = helper(node.left, target);
        TreeNode right = helper(node.right, target);
        if(left != null) {
            node.left = null;
        }
        if(right != null) {
            node.right = null;
        }
        if(node.left == null && node.right == null && node.val == target) {
            return node;
        }
        return null;
    }
}