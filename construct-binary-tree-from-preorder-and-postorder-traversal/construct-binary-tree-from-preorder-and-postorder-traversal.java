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
    private int preIdx, poIdx;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode node = new TreeNode(preorder[preIdx++]);
        if(node.val != postorder[poIdx]) {
            node.left = constructFromPrePost(preorder, postorder);
        }
        if(node.val != postorder[poIdx]) {
            node.right = constructFromPrePost(preorder, postorder);
        }
        poIdx++;
        return node;
    }
}