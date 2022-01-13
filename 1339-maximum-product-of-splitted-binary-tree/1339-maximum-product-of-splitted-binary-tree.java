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
    private long max = 0, total = 0, sub = 0;
    public int maxProduct(TreeNode root) {
        total = helper(root);
        helper(root);
        return (int)(max % (int)(1e9 + 7));
    }
    private long helper(TreeNode node) {
        if(node == null) return 0;
        sub = node.val + helper(node.left) + helper(node.right);
        max = Math.max(max, sub * (total - sub));
        return sub;
    }
        
}