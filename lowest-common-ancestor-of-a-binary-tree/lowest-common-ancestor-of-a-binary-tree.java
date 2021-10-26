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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean pExistLeft = helper(root.left, p);
        boolean qExistRight = helper(root.right, q);
        if(root.val == p. val || root.val == q.val) return root;
        if(pExistLeft && qExistRight) {
            return root;
        }
        boolean qExistLeft = helper(root.left, q);
        if(pExistLeft && qExistLeft){
            return lowestCommonAncestor(root.left, p, q);
        }
        boolean pExistRight = helper(root.right, p);
        if(pExistRight && qExistRight){
            return lowestCommonAncestor(root.right, p, q);
        }
        else return lowestCommonAncestor(root, q, p);
        
    }
    private boolean helper(TreeNode node, TreeNode t) {
        if(node == null) return false;
        if(node.val == t.val) return true;
        return helper(node.left, t) || helper(node.right, t);
    }
}