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
    public void Flatten(TreeNode root) {
        TreeNode node = root;
        while(node != null) {
            if(node.left == null) {
                node = node.right;
            }
            else {
                TreeNode temp = node.left;
                TreeNode pre = temp;
                while(temp.right != null && temp.right != node) {
                    temp = temp.right;
                    pre = temp;
                }
                if(temp.right == node) {
                    TreeNode right = node.right;
                    temp.right = right;
                    node.right = node.left;  
                    node.left = null;
                    node = right;
                }
                else {
                    temp.right = node;
                    node = node.left;
                }
            }
        }
    }
}