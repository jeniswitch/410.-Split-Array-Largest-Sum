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
    public int CountNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftHeight = 1;
        int rightHeight = 1;
        while(left != null) {
            leftHeight++;
            left = left.left;
        }
        while(right != null) {
            rightHeight++;
            right = right.right;
        }
        if(leftHeight == rightHeight) {
            return (int)Math.Pow(2, leftHeight) - 1;
        }
        return CountNodes(root.left) + CountNodes(root.right) + 1;
    }
}