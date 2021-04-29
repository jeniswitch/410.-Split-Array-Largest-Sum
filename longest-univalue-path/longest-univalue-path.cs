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
    public class Node{
        public int val;
        public int count;
        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    private int len;
    public int LongestUnivaluePath(TreeNode root) {
        Helper(root);
        return Math.Max(0, len - 1);
    }
    private Node Helper(TreeNode node) {
        if(node == null) {
            return null;
        }
        if(node.left == null && node.right == null) {
            return new Node(node.val, 1);
        }
        Node left = Helper(node.left);
        Node right = Helper(node.right);
        int count = 1;
        int max = 0;
        if(left != null && node.val == left.val) {
            count += left.count;
            max = Math.Max(left.count, max);
        }
        if(right != null && node.val == right.val) {
            count += right.count;
            max = Math.Max(right.count, max);
        }
        len = Math.Max(count, len);
        return new Node(node.val, max + 1);
    }
}