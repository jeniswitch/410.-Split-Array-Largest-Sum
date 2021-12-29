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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode crr = root;
        TreeNode next = null, pre = null, temp = null;
        while(crr != null) {
            next = crr.left;
            crr.left = temp;
            temp = crr.right;
            crr.right = pre;
            
            pre = crr;
            crr = next;
        }
        return pre;
    }
}