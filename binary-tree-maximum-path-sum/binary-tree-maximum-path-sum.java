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
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max == Integer.MIN_VALUE ? 0 : max;
    }
    private int helper(TreeNode node) {
        if(node == null) return 0;
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        max = Math.max(left + right + node.val, max);
        return node.val + Math.max(left, right);
    }
}