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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> qn = new LinkedList<>();
        Queue<Integer> qd = new LinkedList<>();
        qn.offer(root);
        qd.offer(0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(!qn.isEmpty()) {
            TreeNode node = qn.poll();
            int d = qd.poll();
            min = Math.min(d, min);
            max = Math.max(d, max);
            map.putIfAbsent(d, new ArrayList<>());
            map.get(d).add(node.val);
            if(node.left != null) {
                qn.offer(node.left);
                qd.offer(d - 1);
            }
            if(node.right != null) {
                qn.offer(node.right);
                qd.offer(d + 1);
            }
        }
        for(int i = min; i <= max; i++) {
            if(map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }
}