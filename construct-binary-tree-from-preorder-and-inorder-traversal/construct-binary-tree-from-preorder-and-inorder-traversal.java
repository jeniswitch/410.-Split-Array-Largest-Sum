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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int n = preorder.length - 1;
        return helper(preorder, inorder, 0, n, 0, n);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int pStart, int pEnd, int start, int end) {
        if(pStart > pEnd || start > end) {
            return null;
        }
        if(start == end) {
            return new TreeNode(inorder[start]);
        }
        int idx = 0;
        for(int i = start; i <= end; i++) {
            if(inorder[i] == preorder[pStart]) {
                idx = i;
                break;
            }
        }
        TreeNode node = new TreeNode(inorder[idx]);
        int leftLen = idx - start;
        node.left = helper(preorder, inorder, pStart + 1, pStart + leftLen, start, idx - 1);
        node.right = helper(preorder, inorder, pStart + leftLen + 1, pEnd, idx + 1, end);
        return node;
    }
}