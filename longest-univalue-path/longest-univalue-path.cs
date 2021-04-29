/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {
    private int len;
    public int LongestUnivaluePath(TreeNode root) {
        Helper(root);
        return Math.Max(0, len);
    }
    private int Helper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = Helper(node.left);
        int right = Helper(node.right);
        int leftCount = 0;
        int rightCount = 0;
        if(node.left != null && node.val == node.left.val) {
            leftCount = left + 1;
        }
        if(node.right != null && node.val == node.right.val) {
            rightCount = right + 1;
        }
        len = Math.Max(leftCount + rightCount, len);
        return Math.Max(leftCount, rightCount);
    }
}
