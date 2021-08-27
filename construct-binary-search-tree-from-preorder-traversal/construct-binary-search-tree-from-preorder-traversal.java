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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int start, int end) {
        if(start > end) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[start]);
        if(start == end) {
            return node;
        }
        int next = -1;
        for(int i = start + 1; i <= end; i++) {
            if(preorder[i] > preorder[start]) {
                next = i;
                break;
            }
        }
        if(next == -1) {
            node.left = helper(preorder, start + 1, end);
        }
        else {
            node.left = helper(preorder, start + 1, next - 1);
            node.right = helper(preorder, next, end);
        }
        
        return node;
    }
}