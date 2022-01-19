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
    public int maxSumBST(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    private int[] helper(TreeNode node) {
        //return [sum, min, max]
        if(node == null) {
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int sum = 0;
        if(left != null && right != null && node.val > left[2] && node.val < right[1]) {
            sum = node.val + left[0] + right[0];
            max = Math.max(max, sum);
            return new int[]{sum, Math.min(node.val, left[1]), Math.max(node.val, right[2])};
        }
        else {
            return null;
        }
    }
}