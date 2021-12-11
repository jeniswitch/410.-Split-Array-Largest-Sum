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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> lst = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a - target) - Math.abs(b - target) > 0 ? -1 : 1);
        helper(pq, root, k);
        return new ArrayList<>(pq);
    }
    private void helper(PriorityQueue<Integer> pq, TreeNode node, int k) {
        if(node == null) {
            return;
        }
        helper(pq, node.left, k);
        pq.offer(node.val);
        if(pq.size() > k) {
            pq.poll();
        }
        helper(pq, node.right, k);
    }
}