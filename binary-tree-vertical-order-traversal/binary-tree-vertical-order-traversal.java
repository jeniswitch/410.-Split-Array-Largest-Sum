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
        Map<Integer, List<Integer>> map = new HashMap<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        q.offer(root);
        levels.offer(0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            int level = levels.poll();
            min = Math.min(min, level);
            max = Math.max(max, level);
            map.putIfAbsent(level, new ArrayList<>());
            map.get(level).add(node.val);
            if(node.left != null) {
                q.offer(node.left);
                levels.offer(level - 1);
            }
            if(node.right != null) {
                q.offer(node.right);
                levels.offer(level + 1);
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