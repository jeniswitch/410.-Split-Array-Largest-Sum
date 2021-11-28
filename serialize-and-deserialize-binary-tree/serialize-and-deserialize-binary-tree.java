/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        System.out.println(sb.toString());
        return sb.toString();
    }
    private void buildString(StringBuilder sb, TreeNode node) {
        if(node == null) sb.append("N,");
        else {
            sb.append(node.val + ",");
            buildString(sb, node.left);
            buildString(sb, node.right);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return helper(new LinkedList<>(Arrays.asList(data.split(","))));
    }
    private TreeNode helper(Queue<String> q) {
        String val = q.poll();
        if(val.equals("N")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = helper(q);
            node.right = helper(q);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));