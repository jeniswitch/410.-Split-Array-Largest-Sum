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
    public int longestConsecutive(TreeNode root) {
        max = 1;
        helper(root, 0, null);
        return max;
    }
    private void helper(TreeNode node, int count, TreeNode parent) {
        if(node == null) return;
        if(parent != null && parent.val + 1 == node.val) {
            if(count == 0) count = 2;
            else count++;
            max = Math.max(max, count);
        }
        else {
            count = 0;
        }
        helper(node.left, count, node);
        helper(node.right, count, node);
    }
}