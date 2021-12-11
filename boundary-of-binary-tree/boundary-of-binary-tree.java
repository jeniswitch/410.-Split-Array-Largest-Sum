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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        helper(res, root.left, true, false);
        helper(res, root.right, false, true);
        return res;
    }
    private void helper(List<Integer> lst, TreeNode node, boolean isLeft, boolean isRight) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            lst.add(node.val);
            return;
        }
        if(isLeft) {
             lst.add(node.val);
        }
        helper(lst, node.left, node.left != null && isLeft, node.right == null && isRight);
        helper(lst, node.right, node.left == null && isLeft, node.right != null && isRight);
        if(isRight) {
            lst.add(node.val);
        }
    }
}