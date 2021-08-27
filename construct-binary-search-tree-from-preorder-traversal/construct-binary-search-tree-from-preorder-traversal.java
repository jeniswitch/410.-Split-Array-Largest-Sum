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
    private int i;
    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return helper(preorder, Integer.MAX_VALUE);
    }
    private TreeNode helper(int[] p, int bound) {
        if(i == p.length || p[i] > bound) {
            return null;
        }
        TreeNode node = new TreeNode(p[i++]);
        node.left = helper(p, node.val);
        node.right = helper(p, bound);
        return node;
    }
}
