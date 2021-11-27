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
    private int len;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        len = -1001;
        helper(root);
        return len == -1001 ? 0 : len - 1;
    }
    private int helper(TreeNode node) {
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int count = 1;
        if(node.left != null && node.right != null && node.left.val == node.val && node.right.val == node.val) {
            len = Math.max(len, left + right + 1);
            count += Math.max(left, right);
        }
        else if(node.left != null && node.left.val == node.val) {
            len = Math.max(len, left + 1);
            count += left;
        }
        else if(node.right != null && node.right.val == node.val) {
            len = Math.max(len, right + 1);
            count += right;
        }
        return count;
    }
}