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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        if(root == null) return 0;
        q.offer(root);
        index.offer(1);
        int max = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int start = 0, end = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int idx = index.poll();
                if(i == 0) start = idx;
                if(i == size - 1) end = idx;
                if(node.left != null) {
                    q.offer(node.left);
                    index.offer(2 * idx);
                }
                if(node.right != null) {
                    q.offer(node.right);
                    index.offer(2 * idx + 1);
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}