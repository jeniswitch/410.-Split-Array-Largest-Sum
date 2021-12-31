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
    public int largestBSTSubtree(TreeNode root) {
        int[] res = dfs(root);//count, min, max
        return res[0];
    }
    private int[] dfs(TreeNode node) {
        if(node == null) {
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        if(node.val > left[2] && node.val < right[1]) {
            return new int[]{left[0] + right[0] + 1, Math.min(node.val, left[1]), Math.max(node.val, right[2])};
        }
        return new int[]{Math.max(left[0], right[0]), Integer.MIN_VALUE, Integer.MAX_VALUE};
    }
}