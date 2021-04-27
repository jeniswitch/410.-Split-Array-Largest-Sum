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
    public int LargestBSTSubtree(TreeNode root) {
        return Helper(root)[2];
    }
    private int[] Helper(TreeNode node) {
        if(node == null) {
            return new int[]{Int32.MaxValue, Int32.MinValue, 0};
        }
        int[] left = Helper(node.left);
        int[] right = Helper(node.right);
        if(node.val > left[1] && node.val < right[0]) {
            return new int[]{Math.Min(left[0], node.val), Math.Max(node.val, right[1]), left[2] + right[2] + 1};
        }
        else {
            return new int[]{Int32.MinValue, Int32.MaxValue, Math.Max(left[2], right[2])};
        }
    }
}