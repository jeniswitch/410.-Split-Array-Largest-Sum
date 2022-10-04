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
    Integer lastData = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!isValidBST(root.left)) {
            return false;
        }
        if(lastData != null && root.val <= lastData) {
            return false;
        }
        lastData = root.val;
        return isValidBST(root.right);
    }
}