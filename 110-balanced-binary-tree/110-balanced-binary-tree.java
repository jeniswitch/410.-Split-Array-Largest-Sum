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
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if(left == 0 || right == 0 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }
}