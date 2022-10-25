/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public class Result{
        TreeNode node;
        boolean found;
        public Result(TreeNode n, boolean f) {
            node = n;
            found = f;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result res = helper(root, p, q);
        return res.found ? res.node : null;
    }
    private Result helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return new Result(null, false);
        }
        Result left = helper(root.left, p ,q);
        if(left.found) return left;
        if((root == p || root == q) && left.node != null) {
            return new Result(root, true);
        }
        Result right = helper(root.right, p, q);
        if(right.found) return right;
        if((root == p || root == q) && right.node != null) {
            return new Result(root, true);
        }
        if(root == p || root == q) {
            return new Result(root, false);
        }
        if(left.node != null && right.node != null) {
            return new Result(root, true);
        }
        return left.node != null ? left : right;
    }
}